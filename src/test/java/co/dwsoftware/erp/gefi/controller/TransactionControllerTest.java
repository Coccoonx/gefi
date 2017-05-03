package co.dwsoftware.erp.gefi.controller;


import co.dwsoftware.erp.gefi.Application;
import co.dwsoftware.erp.gefi.model.Cotisation;
import co.dwsoftware.erp.gefi.model.Transaction;
import co.dwsoftware.erp.gefi.model.Membre;
import co.dwsoftware.erp.gefi.model.TypeCotisation;
import co.dwsoftware.erp.gefi.model.TypeTransaction;
import co.dwsoftware.erp.gefi.service.CotisationService;
import co.dwsoftware.erp.gefi.service.TransactionService;
import co.dwsoftware.erp.gefi.service.MembreService;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.module.mockmvc.specification.MockMvcRequestSpecification;
import com.jayway.restassured.response.ResponseOptions;

import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;

@RunWith(SpringJUnit4ClassRunner.class)   // 1
@SpringApplicationConfiguration(classes = Application.class)   // 2
@WebAppConfiguration   // 3
@IntegrationTest("server.port:8081")   // 4
public class TransactionControllerTest {


    @Autowired
    MembreService membreService;

    @Autowired
    CotisationService cotisationService;

    @Autowired
    TransactionService TransactionService;

    @Value("${server.port}")   // 6
            int port;

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp() {
        RestAssured.port = port;
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context).build();
    }

    @Test
    @Transactional
    public void createTransaction() {
        Membre membre = new Membre();
        membre.setNom("Kamga");
        membre.setPrenom("Maurice");
        membre.setAdresse("Makepe");
        membre.setCni("125548518");
        membre.setTelephone("688778899");
        membre = membreService.create(membre);

        Cotisation cotisation = new Cotisation();
        cotisation.setAnnee("2016");
        cotisation.setDateDebut("2016-10-12");
        cotisation.setNom("Cotisation de 2000");
        cotisation.setTypeCotisation(TypeCotisation.TONTINE);
        cotisation = cotisationService.create(cotisation);

        Transaction transaction = new Transaction();
        transaction.setMembre(membre);
        transaction.setCotisation(cotisation);
        transaction.setMontant(10000.0);
        transaction.setType(TypeTransaction.TONTINER);
        

        given().
                body(transaction).
                contentType(ContentType.JSON).
                mockMvc(mockMvc).
                when().
                post("/transaction/cotisation/").
                then().
                statusCode(HttpStatus.SC_OK).
                content("montant", Matchers.equalTo(10000.0));
        
        
    }

/*
    @Test
    @Transactional
    public void update() {
        Membre membre = new Membre();
        membre.setNom("Kamga");
        membre.setPrenom("Maurice");
        membre.setAdresse("Makepe");
        membre.setCni("125548518");
        membre.setTelephone("688778899");
        membre = membreService.create(membre);

        Cotisation cotisation = new Cotisation();
        cotisation.setAnnee("2016");
        cotisation.setDateDebut("2016-10-16");
        cotisation.setNom("Cotisation de 2000");
        cotisation.setType(TypeCotisation.TONTINE);
        cotisation = cotisationService.create(cotisation);

        Transaction transaction = new Transaction();
        transaction.setMembre(membre);
        transaction.setCotisation(cotisation);

        transaction = TransactionService.create(transaction);



        given().
                body(transaction).
                contentType(ContentType.JSON).
                mockMvc(mockMvc).
                when().
                put("/inscription/cotisation/").
                then().
                statusCode(HttpStatus.SC_OK).
                content("montant", Matchers.equalTo(4000.0));
    }*/

/*
    @Test
    @Transactional
    public void updateStudent() {
        Student student = new Student();
        student.setFirstName("Jacques");
        student.setLastName("Ze");
        student.setPassword("foo");
        student.setEmail("myemail@test.com");
        student.setUserName("JZ");

        student = studentRepository.save(student);

        User principal = new User(student.getId().toString(), "foo", true, true, true, true,
                AuthorityUtils.createAuthorityList("USER"));

        student.setFirstName("Georges");
        given().
                body(student).
                contentType(ContentType.JSON).
                mockMvc(mockMvc).
                auth().principalWithCredentials(principal, "foo").
                when().
                put("/student").

                then().
                statusCode(HttpStatus.SC_OK).
                body("firstName", Matchers.containsString("Georges"));
    }


    @Test
    @Transactional
    public void joinCourse() {
        Student student = new Student();
        student.setFirstName("Jacques");
        student.setLastName("Ze");
        student.setPassword("foo");
        student.setEmail("myemail@test.com");
        student.setUserName("JZ");

        student = studentRepository.save(student);

        User principal = new User(student.getId().toString(), "foo", true, true, true, true,
                AuthorityUtils.createAuthorityList("USER"));

        Course course = new Course();
        course.setActivated(true);
        course.setTitle("Java");
        course.setLanguage("fr");
        course.setChapters(new ArrayList<>());
        course.setResources(new ArrayList<>());
        course.setTeachers(new ArrayList<>());
        course.setProjects(new ArrayList<>());

        course = courseRepository.save(course);


        given().
                contentType(ContentType.JSON).
                mockMvc(mockMvc).
                auth().principalWithCredentials(principal, "foo").
                when().
                post("/student/course/" + course.getId()).

                then().
                statusCode(HttpStatus.SC_OK).
                content("courses[0].title", Matchers.containsString("Java"));

    }


    @Test
    @Transactional
    public void leaveCourse() {
        Student student = new Student();
        student.setFirstName("Jacques");
        student.setLastName("Ze");
        student.setPassword("foo");
        student.setEmail("myemail@test.com");
        student.setUserName("JZ");

        student = studentRepository.save(student);

        User principal = new User(student.getId().toString(), "foo", true, true, true, true,
                AuthorityUtils.createAuthorityList("USER"));

        Course course = new Course();
        course.setActivated(true);
        course.setTitle("Java");
        course.setLanguage("fr");
        course.setChapters(new ArrayList<>());
        course.setResources(new ArrayList<>());
        course.setTeachers(new ArrayList<>());
        course.setProjects(new ArrayList<>());

        course = courseRepository.save(course);

        studentService.joinCourse(student.getId(), course.getId());


        given().
                contentType(ContentType.JSON).
                mockMvc(mockMvc).
                auth().principalWithCredentials(principal, "foo").
                when().
                delete("/student/course/" + course.getId()).

                then().
                statusCode(HttpStatus.SC_OK).
                body("courses", Matchers.empty());

    }


    @Test
    @Transactional
    public void findAllCourses() {
        Student student = new Student();
        student.setFirstName("Jacques");
        student.setLastName("Ze");
        student.setPassword("foo");
        student.setEmail("myemail@test.com");
        student.setUserName("JZ");

        student = studentRepository.save(student);

        User principal = new User(student.getId().toString(), "foo", true, true, true, true,
                AuthorityUtils.createAuthorityList("USER"));

        Course course = new Course();
        course.setActivated(true);
        course.setTitle("Java");
        course.setLanguage("fr");
        course.setChapters(new ArrayList<>());
        course.setResources(new ArrayList<>());
        course.setTeachers(new ArrayList<>());
        course.setProjects(new ArrayList<>());

        course = courseRepository.save(course);

        studentService.joinCourse(student.getId(), course.getId());


        given().
                contentType(ContentType.JSON).
                mockMvc(mockMvc).
                auth().principalWithCredentials(principal, "foo").
                when().
                get("/student/course/findAll").

                then().
                statusCode(HttpStatus.SC_OK).
                body("courses", Matchers.not(Matchers.greaterThan(0)));

    }


    @Test
    @Transactional
    public void createOrUpdateAssignment() {
        Student student = new Student();
        student.setFirstName("Jacques");
        student.setLastName("Ze");
        student.setPassword("foo");
        student.setEmail("myemail@test.com");
        student.setUserName("JZ");

        student = studentRepository.save(student);

        User principal = new User(student.getId().toString(), "foo", true, true, true, true,
                AuthorityUtils.createAuthorityList("USER"));

        Assignment assignment = new Assignment();
        assignment.setMessage("exceptions");


        given().
                body(assignment).
                contentType(ContentType.JSON).
                mockMvc(mockMvc).
                auth().principalWithCredentials(principal, "foo").
                when().
                post("/student/assignment").

                then().
                statusCode(HttpStatus.SC_OK).
                content("assignments[0].message", Matchers.containsString("exceptions"));

    }


    @Test
    @Transactional
    public void getAssignment() {
        Student student = new Student();
        student.setFirstName("Jacques");
        student.setLastName("Ze");
        student.setPassword("foo");
        student.setEmail("myemail@test.com");
        student.setUserName("JZ");

        student = studentRepository.save(student);

        User principal = new User(student.getId().toString(), "foo", true, true, true, true,
                AuthorityUtils.createAuthorityList("USER"));

        Assignment assignment = new Assignment();
        assignment.setMessage("exceptions");


        given().
                body(assignment).
                contentType(ContentType.JSON).
                mockMvc(mockMvc).
                auth().principalWithCredentials(principal, "foo").
                when().
                post("/student/assignment").

                then().
                statusCode(HttpStatus.SC_OK).
                content("assignments[0].message", Matchers.containsString("exceptions"));

    }*/



}
package clean.school.usecases

import clean.school.usecases.TestStudentRepo
import clean.school.entity.Student
import clean.school.exceptions.AlreadyExistsException
import clean.school.exceptions.BaseException
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class TestCreateStudent {
    var repo = TestStudentRepo()

    @Test
    fun createFirstBasicValueUser(){
        var createStudent = CreateStudent(repo, createFirstStudent())
        var createdStudent = createStudent.execute()
        assertEquals(createdStudent.id, 1)
    }

    @Test
    fun testCreateTwoValidUsers(){
        var createStudent = CreateStudent(repo, createFirstStudent())
        createStudent.execute()
        createStudent = CreateStudent(repo, createSecondStudent())
        var createdStudent = createStudent.execute()
        assertEquals(createdStudent.id, 2)
    }

    @Test
    fun testCreateTwoUsersWithSameEmail(){
        var createStudent = CreateStudent(repo, createFirstStudent())
        createStudent.execute()
        createStudent = CreateStudent(repo, createFirstStudent())
        var exception = assertFailsWith<AlreadyExistsException>{ 
            createStudent.execute()
        }
        assertEquals(exception.message, "Student with credentials " + createFirstStudent().toString() +" already exists in the system")
    }

    @Test
    fun testCreateUserWithAnInvalidEmail(){
        val student = createFirstStudent()
        student.email = "thisisinvalidemail"
        val createStudent = CreateStudent(repo, student)
        var exception = assertFailsWith<BaseException>{
            createStudent.execute()
        }
        assertEquals(exception.message, "Email " + student.email + " is not a valid email")
    }

    @Test
    fun testCreateStudentWithSpecialCharacterInFirstName(){
        val student = createFirstStudent()
        student.firstName = "inv@l!d"
        val createStudent = CreateStudent(repo, student)
        var exception = assertFailsWith<BaseException>{
            createStudent.execute()
        }
        assertEquals(exception.message, "First name cannot contain special characters. You used " + student.firstName + " as your first name")
    }

    @Test
    fun testCreateStudentWithSpecialCharacterInLastName(){
        val student = createFirstStudent()
        student.lastName = "inv@l!d"
        val createStudent = CreateStudent(repo, student)
        val exception = assertFailsWith<BaseException>{ 
            createStudent.execute() 
        }
        assertEquals(exception.message, "Last Name cannot contain special characters. You used " + student.lastName + " as your last name")
    }

    fun createFirstStudent(): Student {
        return Student(
            firstName = "Paul",
            lastName = "Scholes",
            email = "paul.scholes@england.com",
            password = "p@ulSchole5Pa55word"
        )
    }

    fun createSecondStudent(): Student {
        return Student(
            firstName = "Didier",
            lastName = "Drogba",
            email = "didier@ivorycoast.com",
            password = "d1DierDr0gb@"
        )
    }
}
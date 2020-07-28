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
    fun createFirstBasicValueStudent(){
        var createStudent = CreateStudent(repo, createFirstStudent())
        var createdStudent = createStudent.execute()
        assertEquals(createdStudent.id, 1)
    }

    @Test
    fun testCreateTwoValidStudents(){
        var createStudent = CreateStudent(repo, createFirstStudent())
        createStudent.execute()
        createStudent = CreateStudent(repo, createSecondStudent())
        var createdStudent = createStudent.execute()
        assertEquals(createdStudent.id, 2)
    }

    @Test
    fun testCreateTwoStudentsWithSameEmail(){
        var createStudent = CreateStudent(repo, createFirstStudent())
        createStudent.execute()
        createStudent = CreateStudent(repo, createFirstStudent())
        var exception = assertFailsWith<AlreadyExistsException>{ 
            createStudent.execute()
        }
        assertEquals(exception.message, createFirstStudent().entityName + " credentials " + createFirstStudent().toString() +" already exists in the system")
    }

    @Test
    fun testCreateStudentWithAnInvalidEmail(){
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
        var student = Student()
        student.firstName = "Paul"
        student.lastName = "Scholes"
        student.email = "paul.scholes@england.com"
        student.password = "p@ulSchole5Pa55word"
        student.isDefault = false
        return student
    }

    fun createSecondStudent(): Student {
        var student = Student()
        student.firstName = "Didier"
        student.lastName = "Drogba"
        student.email = "didier@ivorycoast.com"
        student.password = "d1DierDr0gb@"
        student.isDefault = false
        return student
    }
}
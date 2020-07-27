package clean.school.usecases

import clean.school.usecases.TestTeacherRepo
import clean.school.entity.Teacher
import clean.school.exceptions.AlreadyExistsException
import clean.school.exceptions.BaseException
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class TestCreateTeacher {
    
    var repo = TestTeacherRepo()

    @Test
    fun createFirstBasicValueUser(){
        var createTeacher = CreateTeacher(repo, createFirstTeacher())
        var createdTeacher = createTeacher.execute()
        assertEquals(createdTeacher.id, 1)
    }

    @Test
    fun testCreateTwoValidUsers(){
        var createTeacher = CreateTeacher(repo, createFirstTeacher())
        createTeacher.execute()
        createTeacher = CreateTeacher(repo, createSecondTeacher())
        var createdTeacher = createTeacher.execute()
        assertEquals(createdTeacher.id, 2)
    }

    @Test
    fun testCreateTwoUsersWithSameEmail(){
        var createTeacher = CreateTeacher(repo, createFirstTeacher())
        createTeacher.execute()
        createTeacher = CreateTeacher(repo, createFirstTeacher())
        var exception = assertFailsWith<AlreadyExistsException>{ 
            createTeacher.execute()
        }
        assertEquals(exception.message, "credentials " + createFirstTeacher().toString() +" already exists in the system")
    }

    @Test
    fun testCreateUserWithAnInvalidEmail(){
        val teacher = createFirstTeacher()
        teacher.email = "thisisinvalidemail"
        val createStudent = CreateTeacher(repo, teacher)
        var exception = assertFailsWith<BaseException>{
            createStudent.execute()
        }
        assertEquals(exception.message, "Email " + teacher.email + " is not a valid email")
    }

    @Test
    fun testCreateTeacherWithSpecialCharacterInFirstName(){
        val teacher = createFirstTeacher()
        teacher.firstName = "inv@l!d"
        val createTeacher = CreateTeacher(repo, teacher)
        var exception = assertFailsWith<BaseException>{
            createTeacher.execute()
        }
        assertEquals(exception.message, "First name cannot contain special characters. You used " + teacher.firstName + " as your first name")
    }

    @Test
    fun testCreateTeacherWithSpecialCharacterInLastName(){
        val teacher = createFirstTeacher()
        teacher.lastName = "inv@l!d"
        val createTeacher = CreateTeacher(repo, teacher)
        val exception = assertFailsWith<BaseException>{ 
            createTeacher.execute() 
        }
        assertEquals(exception.message, "Last Name cannot contain special characters. You used " + teacher.lastName + " as your last name")
    }

    fun createFirstTeacher(): Teacher {
        var teacher = Teacher()
        teacher.firstName = "Paul"
        teacher.lastName = "Scholes"
        teacher.email = "paul.scholes@england.com"
        teacher.password = "p@ulSchole5Pa55word"
        teacher.isDefault = false
        return teacher

    }

    fun createSecondTeacher(): Teacher {
        var teacher = Teacher()
        teacher.firstName = "Didier"
        teacher.lastName = "Drogba"
        teacher.email = "didier@ivorycoast.com"
        teacher.password = "d1DierDr0gb@"
        teacher.isDefault = false
        return teacher
    }
}

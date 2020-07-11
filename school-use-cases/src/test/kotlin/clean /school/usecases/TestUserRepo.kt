package clean.school.usecases

import clean.school.repository.IStudentRepository
import clean.school.entity.Student

class TestUserRepo: IStudentRepository {
    var nextId = 1
    var students: MutableList<Student> = ArrayList()

    override fun findById(id: Int): Student {
        for (student in students) {
            if (student.id == id)
                return student
        }
        var student = Student()
        student.isDefault = true
        return student
    }

    override fun findByEmail(email: String): Student {
        for (student in students){
            if (student.email == email){
                return student
            }
        }
        var student = Student()
        student.isDefault = true
        return student
    }

    override fun findByEmailAndPassword(email: String, password: String): Student {
        for (student in students){
            if ((student.email == email) && (student.password == password)){
                return student
            }
        }
        var student = Student()
        student.isDefault = true
        return student
    }

    override fun findAllByFirstName(firstName: String): MutableList<Student> {
        var firstNameStudents: MutableList<Student> = ArrayList()

        for (student in students){
            if (student.firstName == firstName){
                firstNameStudents.add(student)
            }
        }
        return firstNameStudents

    }

    override fun findAllByLastName(lastName: String): MutableList<Student> {
        var lastNameStudents: MutableList<Student> = ArrayList()

        for (student in students){
            if (student.lastName == lastName){
                lastNameStudents.add(student)
            }
        }
        return lastNameStudents
    }
    
    override fun findAllByFirstNameAndLastName(firstName: String, lastName: String): MutableList<Student> {
        var firstAndLastNameStudents: MutableList<Student> = ArrayList()

        for (student in students) {
            if ((student.firstName == firstName) && (student.lastName == lastName)) {
                firstAndLastNameStudents.add(student)
            }
        }
        return firstAndLastNameStudents
    }

    override fun save(student: Student): Student {
        student.id = nextId
        nextId += 1
        students.add(student)
        return student
    }

    override fun update(student: Student): Boolean {
        for (x in students) {
            if (x.id == student.id){
                students.remove(x)
                students.add(student)
                return true
            }
        }
        return false
    }

    override fun delete(id: Int): Boolean {
        for (student in students) {
            if (student.id == id){
                students.remove(student)
                return true
            }
        }
        return false
    }
}


package clean.school.usecases

import clean.school.repository.ITeacherRepository
import clean.school.entity.Teacher

class TestTeacherRepo: ITeacherRepository {
    var nextId = 1
    var teachers: MutableList<Teacher> = ArrayList()

    override fun findById(id: Int): Teacher {
        for (teacher in teachers) {
            if (teacher.id == id)
                return teacher
        }
        var teacher = Teacher()
        teacher.isDefault = true
        return teacher
    }

    override fun findByEmail(email: String): Teacher {
        for (teacher in teachers){
            if (teacher.email == email){
                return teacher
            }
        }
        var teacher = Teacher()
        teacher.isDefault = true
        return teacher
    }

    override fun findByEmailAndPassword(email: String, password: String): Teacher {
        for (teacher in teachers){
            if ((teacher.email == email) && (teacher.password == password)){
                return teacher
            }
        }
        var teacher = Teacher()
        teacher.isDefault = true
        return teacher
    }

    override fun findAllByFirstName(firstName: String): MutableList<Teacher> {
        var firstNameTeachers: MutableList<Teacher> = ArrayList()

        for (teacher in teachers){
            if (teacher.firstName == firstName){
                firstNameTeachers.add(teacher)
            }
        }
        return firstNameTeachers

    }

    override fun findAllByLastName(lastName: String): MutableList<Teacher> {
        var lastNameTeachers: MutableList<Teacher> = ArrayList()

        for (teacher in teachers){
            if (teacher.lastName == lastName){
                lastNameTeachers.add(teacher)
            }
        }
        return lastNameTeachers
    }
    
    override fun findAllByFirstNameAndLastName(firstName: String, lastName: String): MutableList<Teacher> {
        var firstAndLastNameTeachers: MutableList<Teacher> = ArrayList()

        for (teacher in teachers) {
            if ((teacher.firstName == firstName) && (teacher.lastName == lastName)) {
                firstAndLastNameTeachers.add(teacher)
            }
        }
        return firstAndLastNameTeachers
    }

    override fun save(teacher: Teacher): Teacher {
        teacher.id = nextId
        nextId += 1
        teachers.add(teacher)
        return teacher
    }

    override fun update(teacher: Teacher): Boolean {
        for (x in teachers) {
            if (x.id == teacher.id){
                teachers.remove(x)
                teachers.add(teacher)
                return true
            }
        }
        return false
    }

    override fun delete(id: Int): Boolean {
        for (teacher in teachers) {
            if (teacher.id == id){
                teachers.remove(teacher)
                return true
            }
        }
        return false
    }
}


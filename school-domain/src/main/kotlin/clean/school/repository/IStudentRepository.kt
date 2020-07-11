package clean.school.repository

import clean.school.entity.Student

interface IStudentRepository {
    fun findById(id: Int): Student
    fun findByEmail(email: String): Student
    fun findByEmailAndPassword(email: String, password: String): Student
    fun findAllByFirstName(firstName: String): Array<Student>
    fun findAllByLastName(lastName: String): Array<Student>
    fun findAllByFirstNameAndLastName(firstName: String, lastName: String): Array<Student>

    fun save(student: Student): Student?
    fun delete(id: Int): Boolean
}

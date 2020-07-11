package clean.school.usecases

import clean.school.repository.IStudentRepository
import clean.school.entity.Student
import clean.school.exceptions.BaseException

class CreateStudent{
    var studentRepository: IStudentRepository 
    var student: Student

    constructor(studentRepository: IStudentRepository, student: Student) {
        this.studentRepository = studentRepository
        this.student = student
    }

    // carry out the create user functionality
    fun execute(): Student {

        if (!checkUniqueCredentials()) {
            throw BaseException("Student with credentials " + student.toString() +" already exists in the system")
        }
        studentRepository.save(student)
        return Student()
    }

    /*
    * checks if the credentials entered are unique
    * for now, only email is checked
    *
    * returns true if the credentials are unique
    * returns false otherwise
    * 
     */
    fun checkUniqueCredentials(): Boolean{
        if (studentRepository.findByEmail(student.email).is_default){
            return false
        }
        return true

    }
}
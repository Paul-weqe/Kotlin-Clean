package clean.school.usecases

import clean.school.repository.IStudentRepository
import clean.school.entity.Student
import clean.school.exceptions.AlreadyExistsException
import clean.school.exceptions.BaseException
import clean.school.validation.BaseValidation

class CreateStudent {
    var studentRepository: IStudentRepository 
    var student: Student

    constructor(studentRepository: IStudentRepository, student: Student){
        this.studentRepository = studentRepository
        this.student = student
    }

    // carry out the create user functionality
    fun execute(): Student {
        if (!credentialsAreUnique()) {
            throw AlreadyExistsException(student.entityName +" credentials " + student.toString() +" already exists in the system")
        } else if (!BaseValidation.validateEmail(student.email)){
            throw BaseException("Email " + student.email + " is not a valid email")
        } else if (BaseValidation.validateInputContainsSpecialCharacter(student.firstName)){
            throw BaseException("First name cannot contain special characters. You used " + student.firstName + " as your first name")
        } else if (BaseValidation.validateInputContainsSpecialCharacter(student.lastName)){
            throw BaseException("Last Name cannot contain special characters. You used " + student.lastName + " as your last name")
        }
        return studentRepository.save(student)
    }

    /*
    * checks if the credentials entered are unique
    * for now, only email is checked. Will be improved in the future
    *
    * returns true if the credentials are unique
    * returns false otherwise
    * 
     */
    fun credentialsAreUnique(): Boolean{
        if (studentRepository.findByEmail(student.email).isDefault == false){
            return false
        }
        return true
    }
    
}
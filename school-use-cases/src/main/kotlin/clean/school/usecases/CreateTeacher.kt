package clean.school.usecases

import clean.school.repository.ITeacherRepository
import clean.school.entity.Teacher
import clean.school.exceptions.AlreadyExistsException
import clean.school.exceptions.BaseException
import clean.school.validation.BaseValidation

class CreateTeacher {
    var teacherRepository: ITeacherRepository 
    var teacher: Teacher

    constructor(teacherRepository: ITeacherRepository, teacher: Teacher) {
        this.teacherRepository = teacherRepository
        this.teacher = teacher
    }


    // carry out the create user functionality
    fun execute(): Teacher {
        if (!credentialsAreUnique()) {
            throw AlreadyExistsException(teacher.entityName +" credentials " + teacher.toString() +" already exists in the system")
        } else if (!BaseValidation.validateEmail(teacher.email)){
            throw BaseException("Email " + teacher.email + " is not a valid email")
        } else if (BaseValidation.validateInputContainsSpecialCharacter(teacher.firstName)){
            throw BaseException("First name cannot contain special characters. You used " + teacher.firstName + " as your first name")
        } else if (BaseValidation.validateInputContainsSpecialCharacter(teacher.lastName)){
            throw BaseException("Last Name cannot contain special characters. You used " + teacher.lastName + " as your last name")
        }
        return teacherRepository.save(teacher)
    }

    /*
    * checks if the credentials entered are unique
    * for now, only email is checked. Will be improved in the future
    *
    * returns true if the credentials are unique
    * returns false otherwise
    * 
     */
    fun credentialsAreUnique(): Boolean {
        if (teacherRepository.findByEmail(teacher.email).isDefault == false){
            return false
        }
        return true
    }
}

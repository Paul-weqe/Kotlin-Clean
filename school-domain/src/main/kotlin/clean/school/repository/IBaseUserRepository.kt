package clean.school.repository

// U is the user class that you will be using
interface IBaseUserRepository<U> {
    fun findById(id: Int): U
    fun findByEmail(email: String): U
    fun findByEmailAndPassword(email: String, password: String): U
    fun findAllByFirstName(firstName: String): MutableList<U>
    fun findAllByLastName(lastName: String): MutableList<U>
    fun findAllByFirstNameAndLastName(firstName: String, lastName: String): MutableList<U>

    fun save(user: U): U
    fun update(user: U): Boolean
    fun delete(id: Int): Boolean
}
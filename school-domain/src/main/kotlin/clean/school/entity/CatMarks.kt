package clean.school.entity

data class CatMarks(
    var id: Int = 0,
    var studentClassroom: StudentClassroom = StudentClassroom(),
    var expected_total: Float = 0F,
    var performed_total: Float = 0F,
    var is_default: Boolean = false
)
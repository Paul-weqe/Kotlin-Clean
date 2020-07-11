package clean.school.entity

data class ExamMarks(
    var id: Int = 0,
    var studentClassroom: StudentClassroom = StudentClassroom(),
    var expectedTotal: Float = 0.0F,
    var performedTotal: Float = 0.0F,
    var is_default: Boolean = false
)
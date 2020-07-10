package clean.school.entity

data class Attendance(
    var id: Int = 0,
    var studentClassroom: StudentClassroom = StudentClassroom(),
    var totalTime: Float = 0.0F,
    var attendedTime: Float = 0.0F
)
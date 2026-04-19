class Student:
    def __init__(self, name, student_id, list_of_grades=None):
        self.name = name
        self.student_id = student_id
        self.list_of_grades = list_of_grades if list_of_grades is not None else []

    def add_grade(self, grade):
        self.list_of_grades.append(grade)

    def get_average(self):
        if not self.list_of_grades:
            return 0
        return sum(self.list_of_grades) / len(self.list_of_grades)

    def get_letter_grade(self):
        average = self.get_average()
        if 90 <= average <= 100:
            return 'A'
        elif 80 <= average <= 89:
            return 'B'
        elif 70 <= average <= 79:
            return 'C'
        elif 60 <= average <= 69:
            return 'D'
        else:
            return 'F'

    def __str__(self):
        return f"{self.name} ({self.student_id}) - {self.get_average()} - {self.get_letter_grade()}"


class GradeManager:
    def __init__(self):
        self.students = {}

    def add_student(self, name, student_id):
        self.students[student_id] = Student(name, student_id)

    def remove_student(self, student_id):
        del self.students[student_id]

    def add_grade_to_student(self, student_id, grade):
        self.students[student_id].add_grade(grade)

    def get_top_student(self):
        max_grade = -1
        student = None
        for student_id in self.students.keys():
            if self.students[student_id].get_average() > max_grade:
                max_grade = self.students[student_id].get_average()
                student = student_id
        return self.students[student]

    def get_failing_students(self):
        failing_students = []
        for student_id in self.students.keys():
            if self.students[student_id].get_letter_grade() == 'F':
                failing_students.append(self.students[student_id])
        return failing_students

    def print_all_students(self):
        for student_id in self.students.keys():
            print(self.students[student_id])


grade_manager = GradeManager()
grade_manager.add_student('Luis', 1)
grade_manager.add_grade_to_student(1, 90)
grade_manager.add_grade_to_student(1, 95)
grade_manager.add_student('Tyler', 2)
grade_manager.add_grade_to_student(2, 99)
grade_manager.add_grade_to_student(2, 98)
grade_manager.add_student('Juan', 3)
grade_manager.add_grade_to_student(3, 50)
grade_manager.add_grade_to_student(3, 95)
grade_manager.print_all_students()
print(grade_manager.get_top_student())
grade_manager.get_failing_students()

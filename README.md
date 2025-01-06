
## Database Design
### Counsellor_table
- counsellor_id(PK)
- counsellor_name
- counsellor_email(unique)
- password
### Enquiry_table
- enquiry_id(PK)
- student_name
- student_phno
- course_name
- course_mode
- status
- counsellor_id(FK) refers Pk of Counsellor_table







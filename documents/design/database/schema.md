
``` mermaid
erDiagram

	event {
		uuid id pk
		varchar subject_id fk
		varchar name
		
		uuid creator_teacher_id fk
		uuid host_teacher_id fk
		
		int timeslot_duration
		int cooldown_duration
		int minimum_timeslot_selection_count
		datetime timeslot_preference_deadline
	}

	timeslot_cluster {
		uuid id pk
		uuid event_id fk
		datetime start_datetime
		datetime end_datetime
	}

	generated_timeslot {
		uuid id pk
		uuid timeslot_cluster_id fk
		datetime start_datetime
		datetime end_datetime
		
	}

	event_student_invitee {
		uuid id pk
		uuid event_id fk
		uuid student_id fk
	}

	student_timeslot_preference {
		uuid id pk
		uuid student_id fk
		uuid generated_timeslot_id fk
		int preference_ranking
	}

	timeslot_student_allocation {
		uuid id pk
		uuid generated_timeslot_id fk
		uuid student_id fk
	}

	subject {
		uuid id pk
		string code
		string name
	}

	subject_student_enrollment {
		uuid id pk
		uuid subject_id fk
		uuid student_id fk
	}

	user {
		uuid id pk
		varchar username
		varchar password
		varchar email
	}

	teacher {
		uuid user_id pk, fk
	}

	student {
		uuid user_id pk, fk
	}

	event 0+--0+ subject : "originates from" 
	event 1--1+ timeslot_cluster : contains
	event 0+--1 teacher : "created by"
	event 0+--1 teacher : "hosted by"
	event 1--1+ event_student_invitee : invites
	timeslot_cluster 1--1+ generated_timeslot : "auto-generates and contains"
	event 1--1+ student : invites
	event_student_invitee |o--1 student : "subset of"
	student 1--0+ student_timeslot_preference : indicates
	generated_timeslot 1--0+ student_timeslot_preference : "allows indication of"
	timeslot_student_allocation |o--o| student : "allocated to"
	timeslot_student_allocation |o--1 generated_timeslot : "allocated from"
	subject 1--0+ subject_student_enrollment : "has" 
	student 1--0+ subject_student_enrollment : "has"


	teacher |o--1 user : is
	student |o--1 user : is




```



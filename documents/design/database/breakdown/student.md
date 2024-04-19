
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
	generated_timeslot {
		uuid id pk
		uuid timeslot_cluster_id fk
		datetime start_datetime
		datetime end_datetime
		
	}
	timeslot_student_allocation {
		uuid id pk
		uuid generated_timeslot_id fk
		uuid student_id fk
	}
	

	timeslot_cluster {
		uuid id pk
		uuid event_id fk
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

	student {
		uuid user_id pk, fk
	}


	event 1--1+ timeslot_cluster : contains

	timeslot_student_allocation |o--1 generated_timeslot : "allocated from"
	timeslot_cluster 1--1+ generated_timeslot : "auto-generates and contains"
	event 1--1+ event_student_invitee : invites
	event_student_invitee |o--1 student : "subset of"
	student 1--0+ student_timeslot_preference : indicates
	generated_timeslot 1--0+ student_timeslot_preference : "allows indication of"
	timeslot_student_allocation |o--o| student : "allocated to"




```



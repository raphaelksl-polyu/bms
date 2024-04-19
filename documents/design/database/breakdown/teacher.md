
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


	subject {
		uuid id pk
		string code
		string name
	}


	teacher {
		uuid user_id pk, fk
	}


	event 0+--0+ subject : "originates from" 
	event 1--1+ timeslot_cluster : contains
	event 0+--1 teacher : "created by"
	event 0+--1 teacher : "hosted by"
	timeslot_cluster 1--1+ generated_timeslot : "auto-generates and contains"









```



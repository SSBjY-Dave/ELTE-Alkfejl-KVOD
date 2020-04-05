-- Labels
insert into `labels` (`label`) VALUES ( 'Hallás sérült' );
insert into `labels` (`label`) VALUES ( 'Látás sérült' );
insert into `labels` (`label`) VALUES ( 'Autista' );
insert into `labels` (`label`) VALUES ( 'Külföldi' );

-- Persons
insert into `person` (`email`, `invite_token`, `name`, `neptun_id`, `newbie`, `password_hash`, `password_salt`) VALUES ('david.orcsik.prog@gmail.com',  '/3NdmpUWlClv2+CaZXYS9gporATzzVZwvTqFH4ShZBE=', 'Orcsik Dávid', 'US4GMR', false, 'poP2suuLKKBPieTLWtrNTAaUTaeqhYpoL1AWvpwpplSPdTMn6MZgi4vYzFkdRvnsrhu81lp1uTIe3O1Qe/DFOQ==', 'w0iDjZkj9EG1xo2jNorgJ5FEtgRLgTHAuzQ3Njhma3Q' );

-- Admins
insert into `admin` (`person_id`) VALUES ( 1 );

-- Rooms
insert into `room` (`level`, `room_number`) VALUES ( 0, 1 );
insert into `room` (`level`, `room_number`) VALUES ( 0, 2 );
insert into `room` (`level`, `room_number`) VALUES ( 0, 3 );
insert into `room` (`level`, `room_number`) VALUES ( 0, 4 );
insert into `room` (`level`, `room_number`) VALUES ( 0, 5 );
insert into `room` (`level`, `room_number`) VALUES ( 0, 6 );

insert into `room` (`level`, `room_number`) VALUES ( 1, 1 );
insert into `room` (`level`, `room_number`) VALUES ( 1, 2 );
insert into `room` (`level`, `room_number`) VALUES ( 1, 3 );
insert into `room` (`level`, `room_number`) VALUES ( 1, 4 );
insert into `room` (`level`, `room_number`) VALUES ( 1, 5 );
insert into `room` (`level`, `room_number`) VALUES ( 1, 6 );
insert into `room` (`level`, `room_number`) VALUES ( 1, 7 );
insert into `room` (`level`, `room_number`) VALUES ( 1, 8 );
insert into `room` (`level`, `room_number`) VALUES ( 1, 9 );
insert into `room` (`level`, `room_number`) VALUES ( 1, 10 );
insert into `room` (`level`, `room_number`) VALUES ( 1, 11 );
insert into `room` (`level`, `room_number`) VALUES ( 1, 12 );
insert into `room` (`level`, `room_number`) VALUES ( 1, 13 );
insert into `room` (`level`, `room_number`) VALUES ( 1, 14 );
insert into `room` (`level`, `room_number`) VALUES ( 1, 15 );

insert into `room` (`level`, `room_number`) VALUES ( 2, 1 );
insert into `room` (`level`, `room_number`) VALUES ( 2, 2 );
insert into `room` (`level`, `room_number`) VALUES ( 2, 3 );
insert into `room` (`level`, `room_number`) VALUES ( 2, 4 );
insert into `room` (`level`, `room_number`) VALUES ( 2, 5 );
insert into `room` (`level`, `room_number`) VALUES ( 2, 6 );
insert into `room` (`level`, `room_number`) VALUES ( 2, 7 );
insert into `room` (`level`, `room_number`) VALUES ( 2, 8 );
insert into `room` (`level`, `room_number`) VALUES ( 2, 9 );
insert into `room` (`level`, `room_number`) VALUES ( 2, 10 );
insert into `room` (`level`, `room_number`) VALUES ( 2, 11 );
insert into `room` (`level`, `room_number`) VALUES ( 2, 12 );
insert into `room` (`level`, `room_number`) VALUES ( 2, 13 );
insert into `room` (`level`, `room_number`) VALUES ( 2, 14 );
insert into `room` (`level`, `room_number`) VALUES ( 2, 15 );

insert into `room` (`level`, `room_number`) VALUES ( 3, 1 );
insert into `room` (`level`, `room_number`) VALUES ( 3, 2 );
insert into `room` (`level`, `room_number`) VALUES ( 3, 3 );
insert into `room` (`level`, `room_number`) VALUES ( 3, 4 );
insert into `room` (`level`, `room_number`) VALUES ( 3, 5 );
insert into `room` (`level`, `room_number`) VALUES ( 3, 6 );
insert into `room` (`level`, `room_number`) VALUES ( 3, 7 );
insert into `room` (`level`, `room_number`) VALUES ( 3, 8 );
insert into `room` (`level`, `room_number`) VALUES ( 3, 9 );
insert into `room` (`level`, `room_number`) VALUES ( 3, 10 );
insert into `room` (`level`, `room_number`) VALUES ( 3, 11 );
insert into `room` (`level`, `room_number`) VALUES ( 3, 12 );
insert into `room` (`level`, `room_number`) VALUES ( 3, 13 );
insert into `room` (`level`, `room_number`) VALUES ( 3, 14 );
insert into `room` (`level`, `room_number`) VALUES ( 3, 15 );

insert into `room` (`level`, `room_number`) VALUES ( 4, 1 );
insert into `room` (`level`, `room_number`) VALUES ( 4, 2 );
insert into `room` (`level`, `room_number`) VALUES ( 4, 3 );
insert into `room` (`level`, `room_number`) VALUES ( 4, 4 );
insert into `room` (`level`, `room_number`) VALUES ( 4, 5 );
insert into `room` (`level`, `room_number`) VALUES ( 4, 6 );
insert into `room` (`level`, `room_number`) VALUES ( 4, 7 );
insert into `room` (`level`, `room_number`) VALUES ( 4, 8 );
insert into `room` (`level`, `room_number`) VALUES ( 4, 9 );
insert into `room` (`level`, `room_number`) VALUES ( 4, 10 );
insert into `room` (`level`, `room_number`) VALUES ( 4, 11 );
insert into `room` (`level`, `room_number`) VALUES ( 4, 12 );
insert into `room` (`level`, `room_number`) VALUES ( 4, 13 );
insert into `room` (`level`, `room_number`) VALUES ( 4, 14 );
insert into `room` (`level`, `room_number`) VALUES ( 4, 15 );

insert into `room` (`level`, `room_number`) VALUES ( 5, 1 );
insert into `room` (`level`, `room_number`) VALUES ( 5, 2 );
insert into `room` (`level`, `room_number`) VALUES ( 5, 3 );
insert into `room` (`level`, `room_number`) VALUES ( 5, 4 );
insert into `room` (`level`, `room_number`) VALUES ( 5, 5 );
insert into `room` (`level`, `room_number`) VALUES ( 5, 6 );
insert into `room` (`level`, `room_number`) VALUES ( 5, 7 );
insert into `room` (`level`, `room_number`) VALUES ( 5, 8 );
insert into `room` (`level`, `room_number`) VALUES ( 5, 9 );
insert into `room` (`level`, `room_number`) VALUES ( 5, 10 );
insert into `room` (`level`, `room_number`) VALUES ( 5, 11 );
insert into `room` (`level`, `room_number`) VALUES ( 5, 12 );
insert into `room` (`level`, `room_number`) VALUES ( 5, 13 );
insert into `room` (`level`, `room_number`) VALUES ( 5, 14 );
insert into `room` (`level`, `room_number`) VALUES ( 5, 15 );

insert into `room` (`level`, `room_number`) VALUES ( 6, 1 );
insert into `room` (`level`, `room_number`) VALUES ( 6, 2 );
insert into `room` (`level`, `room_number`) VALUES ( 6, 3 );
insert into `room` (`level`, `room_number`) VALUES ( 6, 4 );
insert into `room` (`level`, `room_number`) VALUES ( 6, 5 );
insert into `room` (`level`, `room_number`) VALUES ( 6, 6 );
insert into `room` (`level`, `room_number`) VALUES ( 6, 7 );
insert into `room` (`level`, `room_number`) VALUES ( 6, 8 );
insert into `room` (`level`, `room_number`) VALUES ( 6, 9 );
insert into `room` (`level`, `room_number`) VALUES ( 6, 10 );
insert into `room` (`level`, `room_number`) VALUES ( 6, 11 );
insert into `room` (`level`, `room_number`) VALUES ( 6, 12 );
insert into `room` (`level`, `room_number`) VALUES ( 6, 13 );
insert into `room` (`level`, `room_number`) VALUES ( 6, 14 );
insert into `room` (`level`, `room_number`) VALUES ( 6, 15 );

insert into `room` (`level`, `room_number`) VALUES ( 7, 1 );
insert into `room` (`level`, `room_number`) VALUES ( 7, 2 );
insert into `room` (`level`, `room_number`) VALUES ( 7, 3 );
insert into `room` (`level`, `room_number`) VALUES ( 7, 4 );
insert into `room` (`level`, `room_number`) VALUES ( 7, 5 );
insert into `room` (`level`, `room_number`) VALUES ( 7, 6 );
insert into `room` (`level`, `room_number`) VALUES ( 7, 7 );
insert into `room` (`level`, `room_number`) VALUES ( 7, 8 );
insert into `room` (`level`, `room_number`) VALUES ( 7, 9 );
insert into `room` (`level`, `room_number`) VALUES ( 7, 10 );
insert into `room` (`level`, `room_number`) VALUES ( 7, 11 );
insert into `room` (`level`, `room_number`) VALUES ( 7, 12 );
insert into `room` (`level`, `room_number`) VALUES ( 7, 13 );
insert into `room` (`level`, `room_number`) VALUES ( 7, 14 );
insert into `room` (`level`, `room_number`) VALUES ( 7, 15 );

insert into `room` (`level`, `room_number`) VALUES ( 8, 1 );
insert into `room` (`level`, `room_number`) VALUES ( 8, 2 );
insert into `room` (`level`, `room_number`) VALUES ( 8, 3 );
insert into `room` (`level`, `room_number`) VALUES ( 8, 4 );
insert into `room` (`level`, `room_number`) VALUES ( 8, 5 );
insert into `room` (`level`, `room_number`) VALUES ( 8, 6 );
insert into `room` (`level`, `room_number`) VALUES ( 8, 7 );
insert into `room` (`level`, `room_number`) VALUES ( 8, 8 );
insert into `room` (`level`, `room_number`) VALUES ( 8, 9 );
insert into `room` (`level`, `room_number`) VALUES ( 8, 10 );
insert into `room` (`level`, `room_number`) VALUES ( 8, 11 );
insert into `room` (`level`, `room_number`) VALUES ( 8, 12 );
insert into `room` (`level`, `room_number`) VALUES ( 8, 13 );
insert into `room` (`level`, `room_number`) VALUES ( 8, 14 );
insert into `room` (`level`, `room_number`) VALUES ( 8, 15 );

insert into `room` (`level`, `room_number`) VALUES ( 9, 1 );
insert into `room` (`level`, `room_number`) VALUES ( 9, 2 );
insert into `room` (`level`, `room_number`) VALUES ( 9, 3 );
insert into `room` (`level`, `room_number`) VALUES ( 9, 4 );
insert into `room` (`level`, `room_number`) VALUES ( 9, 5 );
insert into `room` (`level`, `room_number`) VALUES ( 9, 6 );
insert into `room` (`level`, `room_number`) VALUES ( 9, 7 );
insert into `room` (`level`, `room_number`) VALUES ( 9, 8 );
insert into `room` (`level`, `room_number`) VALUES ( 9, 9 );
insert into `room` (`level`, `room_number`) VALUES ( 9, 10 );
insert into `room` (`level`, `room_number`) VALUES ( 9, 11 );
insert into `room` (`level`, `room_number`) VALUES ( 9, 12 );
insert into `room` (`level`, `room_number`) VALUES ( 9, 13 );
insert into `room` (`level`, `room_number`) VALUES ( 9, 14 );
insert into `room` (`level`, `room_number`) VALUES ( 9, 15 );

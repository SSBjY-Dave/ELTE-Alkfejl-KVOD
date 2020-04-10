-- Labels
insert into `labels` (`label`) VALUES ( 'Hallás sérült' );
insert into `labels` (`label`) VALUES ( 'Látás sérült' );
insert into `labels` (`label`) VALUES ( 'Autista' );
insert into `labels` (`label`) VALUES ( 'Külföldi' );

-- Persons
insert into `person` (`email`, `invite_token`, `name`, `neptun_id`, `newbie`, `password_hash`, `password_salt`, `gender`) VALUES ('david.orcsik.prog@gmail.com',  '/3NdmpUWlClv2+CaZXYS9gporATzzVZwvTqFH4ShZBE=', 'Orcsik Dávid', 'US4GMR', false, 'poP2suuLKKBPieTLWtrNTAaUTaeqhYpoL1AWvpwpplSPdTMn6MZgi4vYzFkdRvnsrhu81lp1uTIe3O1Qe/DFOQ==', 'w0iDjZkj9EG1xo2jNorgJ5FEtgRLgTHAuzQ3Njhma3Q', 'MALE' );

-- Admins
insert into `admin` (`person_id`) VALUES ( 1 );

-- Rooms
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 0, 1, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 0, 2, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 0, 3, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 0, 4, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 0, 5, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 0, 6, 2, 'AVAILABLE', 'MIXED' );

insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 1, 1, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 1, 2, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 1, 3, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 1, 4, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 1, 5, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 1, 6, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 1, 7, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 1, 8, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 1, 9, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 1, 10, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 1, 11, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 1, 12, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 1, 13, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 1, 14, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 1, 15, 2, 'AVAILABLE', 'MIXED' );

insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 2, 1, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 2, 2, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 2, 3, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 2, 4, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 2, 5, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 2, 6, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 2, 7, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 2, 8, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 2, 9, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 2, 10, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 2, 11, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 2, 12, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 2, 13, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 2, 14, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 2, 15, 2, 'AVAILABLE', 'MIXED' );

insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 3, 1, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 3, 2, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 3, 3, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 3, 4, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 3, 5, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 3, 6, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 3, 7, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 3, 8, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 3, 9, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 3, 10, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 3, 11, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 3, 12, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 3, 13, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 3, 14, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 3, 15, 2, 'AVAILABLE', 'MIXED' );

insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 4, 1, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 4, 2, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 4, 3, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 4, 4, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 4, 5, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 4, 6, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 4, 7, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 4, 8, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 4, 9, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 4, 10, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 4, 11, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 4, 12, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 4, 13, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 4, 14, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 4, 15, 2, 'AVAILABLE', 'MIXED' );

insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 5, 1, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 5, 2, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 5, 3, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 5, 4, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 5, 5, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 5, 6, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 5, 7, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 5, 8, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 5, 9, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 5, 10, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 5, 11, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 5, 12, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 5, 13, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 5, 14, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 5, 15, 2, 'AVAILABLE', 'MIXED' );

insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 6, 1, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 6, 2, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 6, 3, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 6, 4, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 6, 5, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 6, 6, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 6, 7, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 6, 8, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 6, 9, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 6, 10, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 6, 11, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 6, 12, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 6, 13, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 6, 14, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 6, 15, 2, 'AVAILABLE', 'MIXED' );

insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 7, 1, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 7, 2, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 7, 3, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 7, 4, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 7, 5, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 7, 6, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 7, 7, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 7, 8, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 7, 9, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 7, 10, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 7, 11, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 7, 12, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 7, 13, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 7, 14, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 7, 15, 2, 'AVAILABLE', 'MIXED' );

insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 8, 1, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 8, 2, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 8, 3, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 8, 4, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 8, 5, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 8, 6, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 8, 7, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 8, 8, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 8, 9, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 8, 10, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 8, 11, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 8, 12, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 8, 13, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 8, 14, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 8, 15, 2, 'AVAILABLE', 'MIXED' );

insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 9, 1, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 9, 2, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 9, 3, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 9, 4, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 9, 5, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 9, 6, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 9, 7, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 9, 8, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 9, 9, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 9, 10, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 9, 11, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 9, 12, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 9, 13, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 9, 14, 2, 'AVAILABLE', 'MIXED' );
insert into `room` (`level`, `room_number`, `capacity`, `state`, `type`) VALUES ( 9, 15, 2, 'AVAILABLE', 'MIXED' );

insert into `layout` (`person_id`, `room_id`) VALUES ( 1, 23 );
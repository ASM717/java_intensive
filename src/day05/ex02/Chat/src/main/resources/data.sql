insert into chat.users (login, password) VALUES ('esobchak', '@&129342');
insert into chat.users (login, password) VALUES ('mstyr', '@&1293*s');
insert into chat.users (login, password) VALUES ('amuriel', '@&129');
insert into chat.users (login, password) VALUES ('cmerope', '4@&129342');
insert into chat.users (login, password) VALUES ('dgallard', 'qirowund555');
insert into chat.users (login, password) VALUES ('eshakita', '!*duwomeq!');

insert into chat.room (chat_owner, chat_name) VALUES (1, 'chat1');
insert into chat.room (chat_owner, chat_name) VALUES (2, 'chat2');
insert into chat.room (chat_owner, chat_name) VALUES (3, 'chat3');
insert into chat.room (chat_owner, chat_name) VALUES (4, 'chat4');
insert into chat.room (chat_owner, chat_name) VALUES (5, 'chat5');

set timezone = 'Europe/Moscow';

insert into chat.message (room_id, sender, message, time) VALUES (1, 2, 'somebody to love', to_timestamp(extract(epoch FROM now())));
insert into chat.message (room_id, sender, message, time) VALUES (3, 2, 'promise land', to_timestamp(extract(epoch FROM now())));
insert into chat.message (room_id, sender, message, time) VALUES (4, 2, 'just the two uf us', to_timestamp(extract(epoch FROM now())));
insert into chat.message (room_id, sender, message, time) VALUES (1, 2, 'make your move', to_timestamp(extract(epoch FROM now())));
insert into chat.message (room_id, sender, message, time) VALUES (1, 3, 'careless whisper', to_timestamp(extract(epoch FROM now())));
insert into chat.message (room_id, sender, message, time) VALUES (2, 3, 'sing it back', to_timestamp(extract(epoch FROM now())));

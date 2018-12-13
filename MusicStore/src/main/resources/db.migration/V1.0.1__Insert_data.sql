-- Add Authors
INSERT INTO AUTHOR(stage_name, name, birthday, country, genre)
VALUES ('author1', 'author-name1', '01.01.1995', 'Country1', 'rock');
INSERT INTO AUTHOR(stage_name, name, birthday, country, genre)
VALUES ('author2', 'author-name2', '01.01.1995', 'Country2', 'rock');

--Add Songs
INSERT INTO SONG(name, timeline, created_year)
VALUES ('song1', '180', '2000');
INSERT INTO SONG(name, timeline, created_year)
VALUES ('song2', '180', '2000');
INSERT INTO SONG(name, timeline, created_year)
VALUES ('song3', '180', '2000');
INSERT INTO SONG(name, timeline, created_year)
VALUES ('song4', '180', '2000');
INSERT INTO SONG(name, timeline, created_year)
VALUES ('song5', '180', '2000');
INSERT INTO SONG(name, timeline, created_year)
VALUES ('song6', '180', '2000');

--Add Albums
INSERT INTO ALBUM(name, release_date, is_single_album, is_digest, genre)
VALUES ('album1', '01.01.2000', FALSE, TRUE, 'rock');
INSERT INTO ALBUM(name, release_date, is_single_album, is_digest, genre)
VALUES ('album2', '01.01.2000', FALSE, TRUE, 'rock');
INSERT INTO ALBUM(name, release_date, is_single_album, is_digest, genre)
VALUES ('album3', '01.01.2000', FALSE, TRUE, 'rock');
--Add relates
-- author <-> song
INSERT INTO AUTHOR_SONG(author_id, song_id)
VALUES ('1', '1');
INSERT INTO AUTHOR_SONG(author_id, song_id)
VALUES ('1', '2');
INSERT INTO AUTHOR_SONG(author_id, song_id)
VALUES ('1', '3');
INSERT INTO AUTHOR_SONG(author_id, song_id)
VALUES ('2', '4');
INSERT INTO AUTHOR_SONG(author_id, song_id)
VALUES ('2', '5');
INSERT INTO AUTHOR_SONG(author_id, song_id)
VALUES ('2', '6');
-- song <-> album
INSERT INTO SONG_ALBUM(song_id, album_id)
VALUES ('1', '1');
INSERT INTO SONG_ALBUM(song_id, album_id)
VALUES ('2', '1');
INSERT INTO SONG_ALBUM(song_id, album_id)
VALUES ('3', '2');
INSERT INTO SONG_ALBUM(song_id, album_id)
VALUES ('4', '2');
INSERT INTO SONG_ALBUM(song_id, album_id)
VALUES ('5', '3');
INSERT INTO SONG_ALBUM(song_id, album_id)
VALUES ('6', '3');

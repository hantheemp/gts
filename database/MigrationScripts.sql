-- Countries
INSERT INTO countries (code, name) VALUES
('TR', 'Turkey'),
('US', 'United States'),
('GB', 'United Kingdom'),
('DE', 'Germany'),
('FR', 'France');

-- Cities
INSERT INTO cities (country_id, name) VALUES
(1, 'Istanbul'),
(2, 'New York'),
(3, 'London'),
(4, 'Berlin'),
(5, 'Paris');

-- Languages
INSERT INTO languages (code, name) VALUES
('ENG', 'English'),
('TUR', 'Turkish'),
('GER', 'German'),
('FRE', 'French'),
('SPA', 'Spanish');

-- Artists
INSERT INTO artists (name, surname, country_id, city_id, bio, social_links) VALUES
('Deniz', 'Yýlmaz', 1, 1, 'Indie rock singer from Istanbul', '{"spotify":"https://spotify.com/denizyilmaz"}'),
('Alice', 'Johnson', 2, 2, 'Singer-songwriter from New York', '{"instagram":"https://instagram.com/alicejohnson"}'),
('Oliver', 'Smith', 3, 3, 'Alternative artist from London', '{"twitter":"https://twitter.com/oliversmith"}'),
('Hans', 'Müller', 4, 4, 'Electronic producer from Berlin', '{"soundcloud":"https://soundcloud.com/hansmuller"}'),
('Claire', 'Dubois', 5, 5, 'Jazz vocalist from Paris', '{"facebook":"https://facebook.com/clairedubois"}');

-- Albums
INSERT INTO albums (artist_id, title, release_date, cover_art_url) VALUES
(1, 'Blue Horizon', '2021-05-10', 'https://example.com/cover/blue_horizon.jpg'),
(2, 'City Lights', '2020-03-15', 'https://example.com/cover/city_lights.jpg'),
(3, 'Echoes', '2019-07-20', 'https://example.com/cover/echoes.jpg'),
(4, 'Neon Dreams', '2022-11-01', 'https://example.com/cover/neon_dreams.jpg'),
(5, 'Paris Nights', '2018-09-12', 'https://example.com/cover/paris_nights.jpg');

-- Songs (different number per artist)
INSERT INTO songs (artist_id, title, subtitle, release_date, duration_seconds, language_code)
VALUES
(1, 'Silent Waves', 'Acoustic Version', '2021-05-10', 240, 'ENG'),
(1, 'Golden Sky', NULL, '2022-06-18', 210, 'TUR');

-- Artist 2: Alice Johnson (3 songs)
INSERT INTO songs (artist_id, title, subtitle, release_date, duration_seconds, language_code)
VALUES
(2, 'City Lights', NULL, '2020-03-15', 200, 'ENG'),
(2, 'Midnight Drive', NULL, '2021-01-22', 230, 'ENG'),
(2, 'Broken Strings', NULL, '2022-04-10', 250, 'ENG');

-- Artist 3: Oliver Smith (1 song)
INSERT INTO songs (artist_id, title, subtitle, release_date, duration_seconds, language_code)
VALUES
(3, 'Echoes', NULL, '2019-07-20', 260, 'ENG');

-- Artist 4: Hans Müller (4 songs)
INSERT INTO songs (artist_id, title, subtitle, release_date, duration_seconds, language_code)
VALUES
(4, 'Neon Dreams', NULL, '2022-11-01', 300, 'GER'),
(4, 'Pulse', NULL, '2023-02-14', 280, 'GER'),
(4, 'Synth Horizon', NULL, '2023-06-30', 310, 'ENG'),
(4, 'Digital Rain', NULL, '2024-01-05', 295, 'GER');

-- Artist 5: Claire Dubois (2 songs)
INSERT INTO songs (artist_id, title, subtitle, release_date, duration_seconds, language_code)
VALUES
(5, 'Paris Nights', NULL, '2018-09-12', 220, 'FRE'),
(5, 'Moonlight Serenade', NULL, '2019-03-08', 240, 'FRE');

-- Genres
INSERT INTO genres (name) VALUES
('Indie Rock'),
('Acoustic'),
('Singer-Songwriter'),
('Alternative'),
('Electronic'),
('Jazz');

-- Song-Genre mapping
INSERT INTO song_genres (song_id, genre_id) VALUES
(1, 1),
(1, 2), 
(2, 1); 

INSERT INTO song_genres (song_id, genre_id) VALUES
(3, 3),
(4, 3), 
(5, 1);

INSERT INTO song_genres (song_id, genre_id) VALUES
(6, 4);

INSERT INTO song_genres (song_id, genre_id) VALUES
(7, 5), 
(8, 5),
(9, 5), 
(10, 5);

INSERT INTO song_genres (song_id, genre_id) VALUES
(11, 6), 
(12, 6); 

-- Challenge for Jan 4, 2026 (Silent Waves by Deniz Yýlmaz)
INSERT INTO daily_challenges (song_id, challenge_date, metrics)
VALUES (1, '2026-01-04', '["genre","release_year","duration","language","country"]');

-- Challenge for Jan 5, 2026 (City Lights by Alice Johnson)
INSERT INTO daily_challenges (song_id, challenge_date, metrics)
VALUES (3, '2026-01-05', '["genre","release_year","language"]');

-- Challenge for Jan 6, 2026 (Echoes by Oliver Smith)
INSERT INTO daily_challenges (song_id, challenge_date, metrics)
VALUES (6, '2026-01-06', '["genre","duration","country"]');

-- Guesses for Jan 4, 2026 challenge (Silent Waves)
INSERT INTO guesses (nickname, challenge_id, guess, score)
VALUES
('musicfan01', 1, '{"genre":"Indie Rock","release_year":2021,"duration":"over_3min","language":"English","country":"Turkey"}', 5),
('indielover', 1, '{"genre":"Acoustic","release_year":2020,"duration":"under_3min","language":"Turkish","country":"Turkey"}', 2);

-- Guesses for Jan 5, 2026 challenge (City Lights)
INSERT INTO guesses (nickname, challenge_id, guess, score)
VALUES
('nycplayer', 2, '{"genre":"Singer-Songwriter","release_year":2020,"language":"English"}', 3),
('guessmaster', 2, '{"genre":"Indie Rock","release_year":2019,"language":"English"}', 2);

-- Guesses for Jan 6, 2026 challenge (Echoes)
INSERT INTO guesses (nickname, challenge_id, guess, score)
VALUES
('altfan', 3, '{"genre":"Alternative","duration":"over_4min","country":"United Kingdom"}', 3),
('wrongguess', 3, '{"genre":"Electronic","duration":"under_3min","country":"Germany"}', 1);
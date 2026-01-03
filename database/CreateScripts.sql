-- Countries -> Will not be implemented in Spring Boot. Instead, it'll be migrated.
CREATE TABLE countries (
  id SERIAL PRIMARY KEY,
  code CHAR(3) NOT NULL UNIQUE,
  name VARCHAR(100) NOT NULL
);
CREATE INDEX country_name_idx ON country (name);

-- Cities -> Will not be implemented in Spring Boot. Instead, it'll be migrated.
CREATE TABLE city (
  id SERIAL PRIMARY KEY,
  country_id INT NOT NULL REFERENCES country(id) ON DELETE RESTRICT,
  name VARCHAR(100) NOT NULL
);
CREATE UNIQUE INDEX city_country_name_uq ON city (country_id, name);

-- Artists -> Implemented in Spring Boot.
CREATE TABLE artists (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  surname VARCHAR(100),
  country_id INT REFERENCES countries(id),
  city_id INT REFERENCES cities(id),
  bio TEXT,
  social_links JSONB,
  created_at TIMESTAMPTZ DEFAULT now(),
  updated_at TIMESTAMPTZ DEFAULT now()
);
CREATE INDEX artists_name_idx ON artists (lower(name));
CREATE INDEX artists_city_idx ON artists (city_id);
CREATE INDEX ON artists USING gin (social_links);

-- Languages -> Will not be implemented in Spring Boot. Instead, it'll be migrated.
CREATE TABLE languages (
	id SERIAL PRIMARY KEY,
	code CHAR(3) NOT NULL UNIQUE,
	name VARCHAR(100) NOT NULL UNIQUE
);
CREATE INDEX language_name_idx ON languages (name);

-- Songs -> Implemented in Spring Boot.
CREATE TABLE songs (
	id SERIAL PRIMARY KEY,
 	artist_id INT NOT NULL REFERENCES artists(id) ON DELETE CASCADE,
  	title TEXT NOT NULL,
  	subtitle TEXT,
  	release_date DATE,
  	release_year INT GENERATED ALWAYS AS (EXTRACT(YEAR FROM release_date)::INT) STORED,
  	duration_seconds INT,
  	language_code VARCHAR(100) REFERENCES languages(code),
  	created_at TIMESTAMPTZ DEFAULT now(),
  	updated_at TIMESTAMPTZ DEFAULT now()
); -- Other fundamentals of Song entity will take place in different tables for better architecture.
CREATE INDEX songs_artist_idx ON songs (artist_id);
CREATE INDEX songs_release_year_idx ON songs (release_year);

-- Albums -> Implemented in Spring Boot.
CREATE TABLE albums (
  id SERIAL PRIMARY KEY,
  artist_id INT REFERENCES artists(id) ON DELETE CASCADE,
  title VARCHAR(200) NOT NULL,
  release_date DATE,
  cover_art_url TEXT,
  created_at TIMESTAMPTZ DEFAULT now()
);
CREATE INDEX albums_id_idx ON albums(id);
CREATE INDEX albums_title ON albums(title);

-- Genres -> WORKING!!!
CREATE TABLE genres (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100) UNIQUE NOT NULL
);

-- Song-Genre Relationship -> WORKING!!!
CREATE TABLE song_genres (
  song_id INT REFERENCES songs(id) ON DELETE CASCADE,
  genre_id INT REFERENCES genres(id) ON DELETE CASCADE,
  PRIMARY KEY (song_id, genre_id)
);

-- Daily Challenges -> WORKING!!!
CREATE TABLE daily_challenges (
  id SERIAL PRIMARY KEY,
  song_id INT REFERENCES songs(id) ON DELETE CASCADE,
  challenge_date DATE UNIQUE NOT NULL,
  metrics JSONB,
  created_at TIMESTAMPTZ DEFAULT now()
);

-- Guesses -> WORKING!!!
CREATE TABLE guesses (
  id SERIAL PRIMARY KEY,
  nickname VARCHAR(20),
  challenge_id INT REFERENCES daily_challenges(id) ON DELETE CASCADE,
  guess JSONB,
  score INT,
  created_at TIMESTAMPTZ DEFAULT now()
);
CREATE INDEX guesses_nickname_idx ON guesses(nickname);
CREATE INDEX guesses_challenge_id_idx ON guesses(challenge_id);

-- Controller Logs -> Implemented in Spring Boot.
CREATE TABLE controller_logs (
    id BIGSERIAL PRIMARY KEY,
    endpoint VARCHAR(255) NOT NULL,        
    http_method VARCHAR(10) NOT NULL,      
    request_payload JSONB,                
    response_payload JSONB,                 
    status_code INT NOT NULL,              
    client_ip VARCHAR(50),                 
    executed_at TIMESTAMPTZ DEFAULT now()
);
CREATE INDEX idx_controller_logs_endpoint ON controller_logs (endpoint);
CREATE INDEX idx_controller_logs_time ON controller_logs (executed_at);
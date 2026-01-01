-- Countries
CREATE TABLE countries (
  id SERIAL PRIMARY KEY,
  code CHAR(3) NOT NULL UNIQUE,
  name VARCHAR(100) NOT NULL
);
CREATE INDEX country_name_idx ON country (name);

-- Cities
CREATE TABLE city (
  id SERIAL PRIMARY KEY,
  country_id INT NOT NULL REFERENCES country(id) ON DELETE RESTRICT,
  name VARCHAR(100) NOT NULL
);
CREATE UNIQUE INDEX city_country_name_uq ON city (country_id, name);

-- Artists
CREATE TABLE artists (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  surname VARCHAR(100),
  country_id INT REFERENCES country(id),
  city_id INT REFERENCES city(id),
  bio TEXT,
  social_links JSONB,
  created_at TIMESTAMPTZ DEFAULT now(),
  updated_at TIMESTAMPTZ DEFAULT now()
);
CREATE INDEX artists_name_idx ON artists (lower(name));
CREATE INDEX artists_city_idx ON artists (city_id);
CREATE INDEX ON artists USING gin (social_links);

CREATE TABLE languages (
	id SERIAL PRIMARY KEY,
	code CHAR(3) NOT NULL UNIQUE,
	name VARCHAR(100) NOT NULL UNIQUE
);
CREATE INDEX language_name_idx ON languages (name);

-- Songs
CREATE TABLE songs (
	id SERIAL PRIMARY KEY,
 	artist_id INT NOT NULL REFERENCES artists(id) ON DELETE CASCADE,
  	title TEXT NOT NULL,
  	subtitle TEXT,
  	release_date DATE,
  	release_year INT GENERATED ALWAYS AS (EXTRACT(YEAR FROM release_date)::INT) STORED,
  	duration_seconds INT,
  	language VARCHAR(100) REFERENCES languages(name),
  	created_at TIMESTAMPTZ DEFAULT now(),
  	updated_at TIMESTAMPTZ DEFAULT now()
); -- Other fundamentals of Song entity will take place in different tables for better architecture.
CREATE INDEX songs_artist_idx ON songs (artist_id);
CREATE INDEX songs_release_year_idx ON songs (release_year);
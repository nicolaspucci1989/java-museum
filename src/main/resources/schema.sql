USE `dcl-museum`;

CREATE TABLE IF NOT EXISTS booths
(
    id          BIGINT   NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(255),
    artist_name VARCHAR(255),
    artist_bio  VARCHAR(255),
    artist_url  VARCHAR(255),
    expires_at  DATETIME NOT NULL
);

CREATE TABLE IF NOT EXISTS users
(
    id        BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    last_name VARCHAR(255),
    user_name VARCHAR(255),
    email     VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS artworks
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nft_address VARCHAR(255),
    name VARCHAR(255),
    booth_id BIGINT NOT NULL,
    FOREIGN KEY (booth_id) REFERENCES booths (id)
);

CREATE TABLE IF NOT EXISTS booth_artwork
(
    booth_id BIGINT NOT NULL ,
    artwork_id BIGINT NOT NULL ,
    FOREIGN KEY (booth_id) REFERENCES booths (id),
    FOREIGN KEY (artwork_id) REFERENCES artworks (id)
)

CREATE TABLE IF NOT EXISTS booth_user
(
    booth_id BIGINT NOT NULL,
    user_id  BIGINT NOT NULL,
    FOREIGN KEY (booth_id) REFERENCES booths (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);

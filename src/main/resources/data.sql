USE dclmuseum;

INSERT INTO users (name, last_name, user_name, email)
VALUES ('nicolas', 'pucci', 'nicowdk', 'nicowdk@gmail.com');

INSERT INTO booths (name, artist_name, artist_bio, artist_url, expires_at)
VALUES ('Booth one', 'artist one', 'artist bio', 'https://www.google.com', CURRENT_DATE);

INSERT INTO artworks (nft_address, name, booth_id)
VALUES ('0x495f947276749ce646f68ac8c248420045cb7b5e/23005389916031419495497068831589288009900632785309905146382141111059519373313',
        'FungleBot Collective #6555', 1);

INSERT INTO booths_guests (booth_id, guest_id)
VALUES (1, 1);

INSERT INTO booths_artworks
VALUES (1, 1);

SELECT booths.id, booths.name, booths.artist_name,
       artworks.name, artworks.nft_address
FROM booths
JOIN artworks on booths.id = artworks.booth_id;
INSERT INTO station (id_station, name, city) VALUES 
    (1, 'Estación Norte', 'Oviedo'),
    (2, 'Túnel de Guadarrama', 'Madrid'),
    (3, 'Estación Sur', 'Sevilla');

INSERT INTO vehicle (vehicle_id) VALUES 
    ('ABC1234'),
    ('XYZ5678'),
    ('LMN9999'),
    ('MTR4567'),
    ('TCK8000'),
    ('MTR7890'),
    ('CAR3333');

INSERT INTO car (vehicle_id) VALUES 
    ('ABC1234'),
    ('XYZ5678'),
    ('CAR3333');


INSERT INTO moto (vehicle_id) VALUES 
    ('MTR4567'),
    ('MTR7890');

INSERT INTO truck (vehicle_id, axlex) VALUES 
    ('LMN9999', 2),
    ('TCK8000', 3);

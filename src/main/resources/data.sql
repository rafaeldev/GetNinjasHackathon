INSERT INTO service_target (id, name) 
VALUES 
(1, 'Residencia'), (4, 'Moda e beleza'), (3, 'Saude'), (2, 'Empresa');

INSERT INTO service_group (id, name, service_target_id)
VALUES
(1, 'Reforma', 1), (2, 'Diarista', 1), (3, 'Jardineiro', 1), (4, 'Outros servicos', 1);

INSERT INTO service (id, name, service_group_id)
VALUES
(1, 'Pedreiro', 1), (2, 'Eletricista', 1), (3, 'Encanador', 1), (4, 'Marceneiro', 1),
(5, 'Chaveiro', 1), (6, 'Mudancas', 1), (7, 'Limpador de piscina', 1), (8, 'Outras opcoes', 1)
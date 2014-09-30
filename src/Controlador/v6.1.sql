-- DROP SEQUENCE secuencia_minicontroles;
-- DROP SEQUENCE secuencia;
-- DROP TABLE temp;
-- DROP TABLE minicontroles;
-- DROP TABLE historias;
-- DROP TABLE pacientes;

-- Table: pacientes

-- DROP TABLE pacientes;

CREATE TABLE pacientes
(
  cc numeric NOT NULL,
  nombre character varying NOT NULL,
  fechanac date,
  sexo character varying,
  tel numeric,
  direcc character varying,
  celular numeric,
  email character varying,
  ocup character varying,
  observ character varying,
  mas character varying,
  CONSTRAINT "pk-pacientes" PRIMARY KEY (cc )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE pacientes
  OWNER TO postgres;

-- Table: historias

-- DROP TABLE historias;

CREATE TABLE historias
(
  historia_id numeric NOT NULL,
  cc_paciente numeric,
  fecha date,
  tipo character varying,
  acomp character varying,
  parentesco character varying,
  tel numeric,
  motivo character varying,
  antec character varying,
  sc_vl_d character varying,
  sc_vl_i character varying,
  vp character varying,
  cc_vl_d character varying,
  cc_vl_i character varying,
  vp2 character varying,
  ph_d character varying,
  ph_i character varying,
  rx_d character varying,
  rx_i character varying,
  rx_add character varying,
  db_d character varying,
  db_i character varying,
  pio_d character varying,
  pio_i character varying,
  dfo_d character varying,
  dfo_i character varying,
  cvt_vl character varying,
  cvt_vp character varying,
  cvt_ppc character varying,
  q_d character varying,
  q_i character varying,
  refr_d character varying,
  refr_i character varying,
  av_d character varying,
  av_i character varying,
  subjetivo_d character varying,
  subjetivo_i character varying,
  add_d character varying,
  add_i character varying,
  avcc_d character varying,
  avcc_i character varying,
  prescrip_f_d character varying,
  prescrip_f_i character varying,
  add_f_d character varying,
  add_f_i character varying,
  av_vl_d character varying,
  av_vl_i character varying,
  av_vp_d character varying,
  av_vp_i character varying,
  dp character varying,
  ao character varying,
  tipo_lente character varying,
  uso character varying,
  test_color character varying,
  test_profund character varying,
  diagnostico character varying,
  codg_rips character varying,
  conducta character varying,
  control date,
  observaciones character varying,
  CONSTRAINT "pk-historias" PRIMARY KEY (historia_id ),
  CONSTRAINT "fk-historias" FOREIGN KEY (cc_paciente)
      REFERENCES pacientes (cc) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE
)
WITH (
  OIDS=FALSE
);
ALTER TABLE historias
  OWNER TO postgres;


-- Table: minicontroles

-- DROP TABLE minicontroles;

CREATE TABLE minicontroles
(
  minicontrol_id numeric NOT NULL,
  cc_paciente numeric,
  fecha date,
  motivo character varying,
  observaciones character varying,
  CONSTRAINT minicontroles_pkey PRIMARY KEY (minicontrol_id ),
  CONSTRAINT "fk-minicontroles" FOREIGN KEY (cc_paciente)
      REFERENCES pacientes (cc) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE
)
WITH (
  OIDS=FALSE
);
ALTER TABLE minicontroles
  OWNER TO postgres;



-- Table: temp

-- DROP TABLE temp;

CREATE TABLE temp
(
  historia_id numeric,
  cc_paciente numeric,
  fecha date,
  tipo character varying,
  acomp character varying,
  parentesco character varying,
  tel numeric,
  motivo character varying,
  antec character varying,
  sc_vl_d character varying,
  sc_vl_i character varying,
  vp character varying,
  cc_vl_d character varying,
  cc_vl_i character varying,
  vp2 character varying,
  ph_d character varying,
  ph_i character varying,
  rx_d character varying,
  rx_i character varying,
  rx_add character varying,
  db_d character varying,
  db_i character varying,
  pio_d character varying,
  pio_i character varying,
  dfo_d character varying,
  dfo_i character varying,
  cvt_vl character varying,
  cvt_vp character varying,
  cvt_ppc character varying,
  q_d character varying,
  q_i character varying,
  refr_d character varying,
  refr_i character varying,
  av_d character varying,
  av_i character varying,
  subjetivo_d character varying,
  subjetivo_i character varying,
  add_d character varying,
  add_i character varying,
  avcc_d character varying,
  avcc_i character varying,
  prescrip_f_d character varying,
  prescrip_f_i character varying,
  add_f_d character varying,
  add_f_i character varying,
  av_vl_d character varying,
  av_vl_i character varying,
  av_vp_d character varying,
  av_vp_i character varying,
  dp character varying,
  ao character varying,
  tipo_lente character varying,
  uso character varying,
  test_color character varying,
  test_profund character varying,
  diagnostico character varying,
  codg_rips character varying,
  conducta character varying,
  control character varying,
  observaciones character varying
)
WITH (
  OIDS=FALSE
);
ALTER TABLE temp
  OWNER TO postgres;

-- Sequence: secuencia

-- DROP SEQUENCE secuencia;

CREATE SEQUENCE secuencia
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 529
  CACHE 1;
ALTER TABLE secuencia
  OWNER TO postgres;


-- Sequence: secuencia_minicontroles

-- DROP SEQUENCE secuencia_minicontroles;

CREATE SEQUENCE secuencia_minicontroles
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 152
  CACHE 1;
ALTER TABLE secuencia_minicontroles
  OWNER TO postgres;

  insert into pacientes values (1, 'felipe', '1992-08-06', 'MASCULINO', 8776834, 'direccion', 3136108026, 'email', 'ocup', 'observ', 'mas');
insert into pacientes values (2, 'Adriana Clemencia del Corazon de Jesus y de la Santisima Trinidad', '1892-08-06', 'FEMENINO', 8772222, 'direccion2', 3132222222, 'email2', 'ocup2', 'observ2', 'mas2');
insert into pacientes values (3, 'Wilson Libardo', '1942-08-06', 'MASCULINO', 8773333, 'direccion3', 3133333333, 'email3', 'ocup3', 'observ3', 'mas3');
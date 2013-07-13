--
-- PostgreSQL database dump
--

-- Dumped from database version 9.2.4
-- Dumped by pg_dump version 9.2.4
-- Started on 2013-07-12 22:15:04

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

DROP DATABASE weblibrarydb;
--
-- TOC entry 1925 (class 1262 OID 16393)
-- Name: weblibrarydb; Type: DATABASE; Schema: -; Owner: tamaas
--

CREATE DATABASE weblibrarydb WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Hungarian_Hungary.1250' LC_CTYPE = 'Hungarian_Hungary.1250';


ALTER DATABASE weblibrarydb OWNER TO tamaas;

\connect weblibrarydb

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 5 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 1926 (class 0 OID 0)
-- Dependencies: 5
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


--
-- TOC entry 170 (class 3079 OID 11727)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1928 (class 0 OID 0)
-- Dependencies: 170
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- TOC entry 169 (class 1259 OID 16406)
-- Name: user_seq; Type: SEQUENCE; Schema: public; Owner: tamaas
--

CREATE SEQUENCE user_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_seq OWNER TO tamaas;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 168 (class 1259 OID 16396)
-- Name: users; Type: TABLE; Schema: public; Owner: tamaas; Tablespace: 
--

CREATE TABLE users (
    userid numeric NOT NULL,
    version numeric,
    name character varying(256) NOT NULL,
    email character varying(512),
    firstname character varying(64),
    lastname character varying(64),
    password character varying(512) NOT NULL,
    dateofbirth date,
    placeofbirth character varying(512),
    timezone character varying(16)
);


ALTER TABLE public.users OWNER TO tamaas;

--
-- TOC entry 1929 (class 0 OID 0)
-- Dependencies: 169
-- Name: user_seq; Type: SEQUENCE SET; Schema: public; Owner: tamaas
--

SELECT pg_catalog.setval('user_seq', 2, true);


--
-- TOC entry 1919 (class 0 OID 16396)
-- Dependencies: 168
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: tamaas
--

INSERT INTO users (userid, version, name, email, firstname, lastname, password, dateofbirth, placeofbirth, timezone)
    VALUES (1, 1, 'tamaas', 'penzes.tamas@gmail.com', 'Test', 'User', 'password', '1980-03-24', '', '');


--
-- TOC entry 1918 (class 2606 OID 16405)
-- Name: userid_pkey; Type: CONSTRAINT; Schema: public; Owner: tamaas; Tablespace: 
--

ALTER TABLE ONLY users
    ADD CONSTRAINT userid_pkey PRIMARY KEY (userid);


--
-- TOC entry 1927 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2013-07-12 22:15:05

--
-- PostgreSQL database dump complete
--


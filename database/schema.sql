-- =============================================
-- DROP TABLES
-- =============================================

DROP TABLE IF EXISTS project_skills CASCADE;
DROP TABLE IF EXISTS project_sections CASCADE;
DROP TABLE IF EXISTS projects CASCADE;
DROP TABLE IF EXISTS skills CASCADE;
DROP TABLE IF EXISTS education CASCADE;
DROP TABLE IF EXISTS experiences CASCADE;
DROP TABLE IF EXISTS profile CASCADE;


-- =============================================
-- DROP ENUMS
-- =============================================

DROP TYPE IF EXISTS profile_status_enum CASCADE;
DROP TYPE IF EXISTS project_status_enum CASCADE;
DROP TYPE IF EXISTS employment_type_enum CASCADE;
DROP TYPE IF EXISTS image_position_enum CASCADE;


-- =============================================
-- ENUMS
-- =============================================

CREATE TYPE profile_status_enum AS ENUM (
    'open to work',
    'selective projects',
    'not available'
    );


CREATE TYPE project_status_enum AS ENUM (
    'ongoing',
    'completed',
    'archived'
    );


CREATE TYPE employment_type_enum AS ENUM (
    'full-time',
    'part-time',
    'internship',
    'contract',
    'freelance'
    );


CREATE TYPE image_position_enum AS ENUM (
    'left',
    'right',
    'none'
    );


-- =============================================
-- PROFILE
-- =============================================

CREATE TABLE profile
(
    id           SERIAL PRIMARY KEY,
    name         VARCHAR(255)        NOT NULL,
    role         VARCHAR(255)        NOT NULL,
    location     VARCHAR(255),
    status       profile_status_enum NOT NULL DEFAULT 'open to work',
    email        VARCHAR(255),
    profile_url  VARCHAR(2048),
    github_url   VARCHAR(2048),
    linkedin_url VARCHAR(2048),
    cv_url       VARCHAR(2048)
);


-- =============================================
-- PROJECTS
-- =============================================

CREATE TABLE projects
(
    id               SERIAL PRIMARY KEY,
    slug             VARCHAR(255)        NOT NULL UNIQUE,
    title            VARCHAR(255)        NOT NULL,
    subtitle         TEXT,
    client           VARCHAR(255),
    role             VARCHAR(255),
    start_date       DATE,
    end_date         DATE,
    description      TEXT                NOT NULL,
    status           project_status_enum NOT NULL DEFAULT 'ongoing',
    repository_url   VARCHAR(2048),
    live_demo_url    VARCHAR(2048),
    thumbnail_url    VARCHAR(2048),
    is_featured      BOOLEAN             NOT NULL DEFAULT FALSE,
    is_kodon_project BOOLEAN             NOT NULL DEFAULT FALSE,

    CONSTRAINT projects_date_check
        CHECK (
            end_date IS NULL
                OR start_date IS NULL
                OR end_date >= start_date
            )
);


-- =============================================
-- PROJECT SECTIONS
-- =============================================

CREATE TABLE project_sections
(
    id             SERIAL PRIMARY KEY,
    project_id     INTEGER             NOT NULL,
    display_order  INTEGER             NOT NULL,
    image_url      VARCHAR(2048),
    image_position image_position_enum NOT NULL DEFAULT 'none',
    content        TEXT                NOT NULL,

    CONSTRAINT fk_project_sections_project
        FOREIGN KEY (project_id)
            REFERENCES projects (id)
            ON DELETE CASCADE,

    CONSTRAINT unique_project_section_order
        UNIQUE (project_id, display_order)
);


-- =============================================
-- SKILLS
-- =============================================

CREATE TABLE skills
(
    id         SERIAL PRIMARY KEY,
    name       VARCHAR(255) NOT NULL UNIQUE,
    start_date DATE
);


-- =============================================
-- PROJECT SKILLS
-- =============================================

CREATE TABLE project_skills
(
    project_id INTEGER NOT NULL,
    skill_id   INTEGER NOT NULL,

    PRIMARY KEY (project_id, skill_id),

    CONSTRAINT fk_project_skills_project
        FOREIGN KEY (project_id)
            REFERENCES projects (id)
            ON DELETE CASCADE,

    CONSTRAINT fk_project_skills_skill
        FOREIGN KEY (skill_id)
            REFERENCES skills (id)
            ON DELETE RESTRICT
);


-- =============================================
-- EDUCATION
-- =============================================

CREATE TABLE education
(
    id          SERIAL PRIMARY KEY,
    title       VARCHAR(255) NOT NULL,
    institution VARCHAR(255) NOT NULL,
    location    VARCHAR(255),
    start_date  DATE         NOT NULL,
    end_date    DATE,
    grade       VARCHAR(255),
    description TEXT,

    CONSTRAINT education_date_check
        CHECK (
            end_date IS NULL
                OR end_date >= start_date
            )
);


-- =============================================
-- EXPERIENCES
-- =============================================

CREATE TABLE experiences
(
    id              SERIAL PRIMARY KEY,
    title           VARCHAR(255)         NOT NULL,
    company         VARCHAR(255)         NOT NULL,
    employment_type employment_type_enum NOT NULL,
    location        VARCHAR(255),
    start_date      DATE                 NOT NULL,
    end_date        DATE,
    description     TEXT,

    CONSTRAINT experiences_date_check
        CHECK (
            end_date IS NULL
                OR end_date >= start_date
            )
);

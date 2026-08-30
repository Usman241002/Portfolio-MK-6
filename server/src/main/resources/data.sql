-- =============================================
-- PROFILE
-- =============================================

INSERT INTO profile (
    name,
    role,
    location,
    status,
    email,
    profile_url,
    github_url,
    linkedin_url,
    cv_url
)
VALUES (
           'Usman Khalid',
           'Software Engineer',
           'Birmingham, United Kingdom',
           'open to work',
           'usman@example.com',
           'https://ukhalid.dev',
           'https://github.com/ukhalid',
           'https://linkedin.com/in/ukhalid',
           '/uploads/cv.pdf'
       );


-- =============================================
-- PROJECTS
-- =============================================

INSERT INTO projects (
    slug,
    title,
    subtitle,
    client,
    role,
    start_date,
    end_date,
    description,
    status,
    repository_url,
    live_demo_url,
    thumbnail_url,
    is_featured,
    is_kodon_project
)
VALUES
    (
        'portfolio-api',
        'Portfolio API',
        'A REST API powering a personal portfolio website',
        'Personal Project',
        'Backend Developer',
        DATE '2026-06-01',
        NULL,
        'A REST API built with Spring Boot for managing portfolio projects, skills, education and professional experience.',
        'ongoing',
        'https://github.com/example/portfolio-api',
        NULL,
        '/images/projects/portfolio-api.png',
        TRUE,
        FALSE
    ),
    (
        'kodon',
        'KODON',
        'Custom software and digital systems',
        'KODON',
        'Founder and Software Engineer',
        DATE '2026-07-01',
        NULL,
        'A business website and digital platform for a software development company.',
        'ongoing',
        'https://github.com/example/kodon',
        'https://kodon.uk',
        '/images/projects/kodon.png',
        TRUE,
        TRUE
    ),
    (
        'social-media-api',
        'Sphere API',
        'A social media REST API',
        'Personal Project',
        'Backend Developer',
        DATE '2025-01-10',
        DATE '2025-04-15',
        'A backend API providing authentication, users, posts and social features.',
        'completed',
        'https://github.com/example/sphere-api',
        NULL,
        '/images/projects/sphere.png',
        FALSE,
        FALSE
    ),
    (
        'pet-tracker',
        'Pet Tracker',
        'Application for tracking pets and their information',
        'Personal Project',
        'Full Stack Developer',
        DATE '2025-06-01',
        DATE '2025-08-20',
        'A full stack application for managing pet information and records.',
        'completed',
        'https://github.com/example/pet-tracker',
        NULL,
        '/images/projects/pet-tracker.png',
        FALSE,
        FALSE
    );


-- =============================================
-- PROJECT SECTIONS
-- =============================================

INSERT INTO project_sections (
    project_id,
    display_order,
    image_url,
    image_position,
    content
)
VALUES
    (
        1,
        1,
        '/images/projects/portfolio-api-architecture.png',
        'right',
        '# Overview

    This project provides the backend for a portfolio website.

    It exposes REST endpoints for projects, skills, education and experience.'
    ),
    (
        1,
        2,
        NULL,
        'none',
        '# Technology

    The API is built using Spring Boot and uses a relational database for persistent data.'
    ),
    (
        2,
        1,
        '/images/projects/kodon-homepage.png',
        'left',
        '# KODON

    KODON provides custom software and digital systems for businesses.'
    ),
    (
        2,
        2,
        '/images/projects/kodon-services.png',
        'right',
        '# Services

    The platform showcases software development and digital solutions.'
    ),
    (
        3,
        1,
        NULL,
        'none',
        '# API Features

    The API supports users, authentication, posts and social interactions.'
    );


-- =============================================
-- SKILLS
-- =============================================

INSERT INTO skills (
    name,
    start_date
)
VALUES
    (
        'Java',
        DATE '2024-01-01'
    ),
    (
        'Spring Boot',
        DATE '2026-01-01'
    ),
    (
        'JavaScript',
        DATE '2023-01-01'
    ),
    (
        'TypeScript',
        DATE '2024-01-01'
    ),
    (
        'React',
        DATE '2024-01-01'
    ),
    (
        'Vue.js',
        DATE '2025-01-01'
    ),
    (
        'PostgreSQL',
        DATE '2024-01-01'
    ),
    (
        'Docker',
        DATE '2025-01-01'
    ),
    (
        'Git',
        DATE '2023-01-01'
    );


-- =============================================
-- PROJECT SKILLS
-- =============================================

INSERT INTO project_skills (
    project_id,
    skill_id
)
VALUES
-- Portfolio API
(1, 1),
(1, 2),
(1, 7),

-- KODON
(2, 3),
(2, 4),
(2, 6),

-- Sphere API
(3, 3),
(3, 7),

-- Pet Tracker
(4, 3),
(4, 4),
(4, 5);


-- =============================================
-- EDUCATION
-- =============================================

INSERT INTO education (
    title,
    institution,
    location,
    start_date,
    end_date,
    grade,
    description
)
VALUES
    (
        'BSc (Hons) Software Engineering',
        'Coventry University',
        'Coventry, United Kingdom',
        DATE '2023-09-01',
        DATE '2026-07-01',
        'First Class Honours',
        'Studied software engineering, programming, databases, software architecture and web development.'
    ),
    (
        'A Levels',
        'Example Sixth Form',
        'Birmingham, United Kingdom',
        DATE '2021-09-01',
        DATE '2023-06-01',
        NULL,
        'Completed further education before studying software engineering.'
    );


-- =============================================
-- EXPERIENCES
-- =============================================

INSERT INTO experiences (
    title,
    company,
    employment_type,
    location,
    start_date,
    end_date,
    description
)
VALUES
    (
        'Software Engineer and Founder',
        'KODON',
        'freelance',
        'Birmingham, United Kingdom',
        DATE '2026-08-01',
        NULL,
        'Designing and building custom software and digital systems for businesses.'
    ),
    (
        'Software Developer',
        'Personal Projects',
        'freelance',
        'Birmingham, United Kingdom',
        DATE '2024-01-01',
        DATE '2026-07-01',
        'Developed full stack applications, REST APIs and database-driven systems.'
    );

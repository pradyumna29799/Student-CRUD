-- Create database
CREATE DATABASE IF NOT EXISTS student_crud;
USE student_crud;

-- Create students table with auto-increment ID
CREATE TABLE IF NOT EXISTS students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    department VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Example insert (optional)
-- INSERT INTO students (name, department, age) VALUES ('John Doe', 'CSE', 20);

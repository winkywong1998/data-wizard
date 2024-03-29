DROP TABLE IF EXISTS USER;
CREATE TABLE USER( Uid INTEGER PRIMARY KEY, Upwd VARCHAR(15), LName VARCHAR(15), FName VARCHAR(15), Phone VARCHAR(15) );
DROP TABLE IF EXISTS Isparticipant;
CREATE TABLE Isparticipant( Uid INTEGER , ParticipantId INTEGER );
DROP TABLE IF EXISTS Participant;
CREATE TABLE Participant( ParticipantId INTEGER PRIMARY KEY, Degree VARCHAR(1), Major VARCHAR(15), YearOfCoding INTEGER, NumOfExp INTEGER, RorI VARCHAR(1) );
DROP TABLE IF EXISTS IsVolunteer;
CREATE TABLE IsVolunteer( ParticipantId INTEGER, VolunteerId INTEGER );
DROP TABLE IF EXISTS Volunteer;
CREATE TABLE Volunteer( VolunteerId INTEGER PRIMARY KEY, Phone VARCHAR(13), HelpTime INTEGER, CourseNum INTEGER );
DROP TABLE IF EXISTS SupervisedBy;
CREATE TABLE SupervisedBy( AdminId INTEGER, VolunteerId INTEGER );
DROP TABLE IF EXISTS IsAdmin;
CREATE TABLE IsAdmin( Uid INTEGER , AdminId INTEGER );
DROP TABLE IF EXISTS Admin;
CREATE TABLE Admin( AdminId INTEGER PRIMARY KEY, IsLeader VARCHAR(1) );
DROP TABLE IF EXISTS HOLD;
CREATE TABLE HOLD( AdminId INTEGER, MeetingId INTEGER );
DROP TABLE IF EXISTS Meeting;
CREATE TABLE Meeting( MeetingId INTEGER PRIMARY KEY, TIME TIMESTAMP, Location VARCHAR(30), TeamCapacity INTEGER );
DROP TABLE IF EXISTS Helps;
CREATE TABLE Helps( VolunteerId INTEGER, MeetingId INTEGER );
DROP TABLE IF EXISTS Attend;
CREATE TABLE Attend( TeamId INTEGER, MeetingId INTEGER );
DROP TABLE IF EXISTS Register;
CREATE TABLE Register( TeamId INTEGER, MeetingId INTEGER );
DROP TABLE IF EXISTS Team;
CREATE TABLE Team( TeamId INTEGER PRIMARY KEY, MeetingTimes INTEGER, TeamName VARCHAR(10) );
DROP TABLE IF EXISTS Memberof;
CREATE TABLE Memberof( ParticipantId INTEGER, TeamId INTEGER );
DROP TABLE IF EXISTS HasFeedBack;
CREATE TABLE HasFeedBack( UserId INTEGER, FeedbackId INTEGER );
DROP TABLE IF EXISTS Feedback;
CREATE TABLE Feedback( FeedbackId INTEGER PRIMARY KEY, Text VARCHAR(100), Score INTEGER );
DROP TABLE IF EXISTS IsAbout;
CREATE TABLE IsAbout( FeedbackId INTEGER, MeetingId INTEGER );
DROP TABLE IF EXISTS Send;
CREATE TABLE send( UserId INTEGER, MessageId INTEGER );
DROP TABLE IF EXISTS Receive;
CREATE TABLE Receive( UserId INTEGER, MessageId INTEGER );
DROP TABLE IF EXISTS Message;
CREATE TABLE Message( MassageId INTEGER PRIMARY KEY, TIME DATETIME, Text VARCHAR(100) );
DROP TABLE IF EXISTS Post;
CREATE TABLE Post( UserId INTEGER, BoardId INTEGER );
DROP TABLE IF EXISTS Follow;
CREATE TABLE Follow( UserId INTEGER, BoardId INTEGER );
DROP TABLE IF EXISTS Board;
CREATE TABLE Board( BoardId INTEGER PRIMARY KEY, TIME DATETIME, Text VARCHAR(100) );
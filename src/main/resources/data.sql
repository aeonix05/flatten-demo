INSERT INTO user(empid, accesskey, country) VALUES ('Miller', 'TRMLLR', 'SG')
INSERT INTO user(empid, accesskey, country) VALUES ('Tessa', 'TRTSSA', 'SG')
INSERT INTO user(empid, accesskey, country) VALUES ('Dosson', 'TRDSSN', 'HK')
INSERT INTO user(empid, accesskey, country) VALUES ('Ricky', 'TRRCKY', 'SG')
INSERT INTO user(empid, accesskey, country) VALUES ('Aaron', 'TRARON', 'SG')
INSERT INTO user(empid, accesskey, country) VALUES ('Bob', 'TRBOB', 'HK')

INSERT INTO teamhierarchy(id, empid, managerid) VALUES ('1', 'Tessa', 'Miller')
INSERT INTO teamhierarchy(id, empid, managerid) VALUES ('2', 'Dosson', 'Miller')
INSERT INTO teamhierarchy(id, empid, managerid) VALUES ('3', 'Ricky', 'Tessa')
INSERT INTO teamhierarchy(id, empid, managerid) VALUES ('4', 'Aaron', 'Tessa')
INSERT INTO teamhierarchy(id, empid, managerid) VALUES ('5', 'Bob', 'Dosson')
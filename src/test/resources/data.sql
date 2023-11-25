INSERT INTO end_user (passwd, sid, user_name)
VALUES ('$10$lu7IyMib6wpf3VDUA71Q/u2Ve0OkRrNihPUapLDdofVSoHc7ReyB2', 'S231101', 'William');

INSERT INTO permission (permission_description, permission_name)
VALUES('View Accounting info', 'ACCOUNTING_VIEW');

INSERT INTO auth_group (group_description, group_name)
VALUES('Accounting Department', 'BANK_ACCOUNTING_STAFF');

INSERT INTO group_permission_mp
(auth_group_id, permission_id)
VALUES(1, 1);

INSERT INTO user_group_mp
(auth_group_id, sid)
VALUES(1, 'S231101');


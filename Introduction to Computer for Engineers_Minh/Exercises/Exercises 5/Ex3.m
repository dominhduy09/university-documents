% a. Create a column vector t with elements from 1 to 10 with spacing of 0.5
t = (1:0.5:10)';
disp('Vector t:');
disp(t);

% b. Create a matrix A with columns t, t^2, t^3, and t^4
A = [t t.^2 t.^3 t.^4];
disp('Matrix A:');
disp(A);

% c. Add one more column to the right with 1 if t > 5 and 0 otherwise
column_c = (t > 5);
A = [A column_c];
disp('Matrix A with additional column based on t > 5:');
disp(A);

% d. Add one more column to the right with 5 if t is an integer and 0 otherwise
column_d = (mod(t, 1) == 0) * 5;
A = [A column_d];
disp('Matrix A with additional column based on integer values of t:');
disp(A);


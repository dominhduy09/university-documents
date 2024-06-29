u1 = [1 ; 2 ; 3];
u2 = [-5 ; 2 ; 1];
u3 = [-1 ; -3 ; 7];

A = [2 3 4; 7 6 5; 2 8 7];

disp('PART 1');
disp('(b) Result:');
disp(u1 + 3*u2 - u3/5)

disp('(c) Dot product between u1 and u2:');
disp(dot(u1, u2))

disp('(d) Product of A and u1:');
disp(A * u1)

disp('PART 2');
% Calculate |u1|_2
norm_u1_2 = norm(u1); % Euclidean norm

% Calculate |u2|_1
norm_u2_1 = norm(u2, 1); % L1 norm

% Calculate |u3|_∞
norm_u3_inf = norm(u3, Inf); % Infinity norm

disp('(a) Norms:');
disp(['|u1|_2: ' num2str(norm_u1_2)]);
disp(['|u2|_1: ' num2str(norm_u2_1)]);
disp(['|u3|_∞: ' num2str(norm_u3_inf)]);

% Dimensions of matrix A
[m, n] = size(A);

disp('(b) Dimensions of matrix A:');
disp(['Number of rows: ' num2str(m)]);
disp(['Number of columns: ' num2str(n)]);

% Determinant of A
det_A = det(A);

% Inverse of A
inv_A = inv(A);

disp('(c) Determinant and Inverse of matrix A:');
disp(['Determinant of A: ' num2str(det_A)]);
disp('Inverse of A:');
disp(inv_A);

disp('PART 3');
x1 = A \ u1;
disp('Solution to Ax = u1 using matrix left division (\):');
disp(x1);

x2 = inv(A) * u1;
disp('Solution to Ax = u1 using explicit matrix inversion:');
disp(x2);


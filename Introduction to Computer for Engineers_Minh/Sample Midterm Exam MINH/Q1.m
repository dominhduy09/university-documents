% Question 1
% a. A random integer number from 1 to 20
randi(20);

% b. A random odd integer number from 11 to 99
11 + 2*randi([0 44]);
1 + 2*randi([5 49]);

% c. A random even integer number from -50 to 50
-50 + 2*randi([0 50]);
2*randi([-25 25]);

% d. A random integer number from 10 to 99 and divisible by 3
3*randi([4 33]);

% e. A random float number from 6.3 to 36.6
sprintf('%1.1f', 6.3 + 30.3*rand(1));

% f. A random float number from -18.9 to 66.3
sprintf('%1.1f', -18.9 + 85.2*randi(1));

% g. A row vector with 10 random integer elements from 23 to 78
randi([23 78], 1, 10);

% h. A column vector with 15 random float elements from 1.1 to 9.9
1.1 + 8.8*rand(15,1);

% i. A matrix 3x4 with random integer elements from -25 to 25 and divisible by 5
5*randi([-5 5], 3, 4);

% j. A matrix 6x6 with first three columns are random integers from 3 to 30, last three columns are random floats from 2.4 to 6.9
J = zeros(6);
for i = 1 : 6
    for j = 1 : 3
        J(i,j) = randi([3 30]);
    end
    for j = 4 : 6
        J(i,j) = 2.4 + 4.5*rand(1);
    end
end

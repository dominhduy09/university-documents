clear all;
close all;
clc;

%input  matrix A
A = [2 1 3;2 6 8;6 8 18]
%Nguyễn Đào Anh Khôi
%input col vector b
b=[1;3;5]
%create an augment matrix [A|b]
M=[A b]
%demo some matrix operation
%get the first row of matrix A
A(1,:)
%get the diagnal element of any rows, says first row
A(1,1)
%A(2,2)
% apply row elementary operations on the 1st column
%says row1 =row 1/diagonal element of row 1
A(1,:) = A(1,:)/A(1,1)
%Gausian Elimination
%forward step
%pivot come to 1
M(1,:)= M(1,:)/ M(1,1);
%make other number come to zero
M(2,:)= M(2,:)-M(1,:).*M(2,1);
M(3,:)= M(3,:)-M(1,:).*M(3,1);

%step 2: make 2rd pivot to zero
M(2,:)= M(2,:)/ M(2,2);
%keep make other number come to zero: 2rd time
M(3,:)= M(3,:) - M(2,:).*M(3,2);


%step 3: make 3rd pivot to zero
M(3,:)= M(3,:)/ M(3,3);

%%Back- substition
x= zeros(3,1);
%Substep 1
x(3,1)= M(3,4) / M(3,3)
%Substep 2
x(2,1)= 2/5 - x(3,1)
%Substep 3
x(1,1)= 1/2-1/2*x(2,1)-3/2*x(3,1)


printf('  solution is \n ');


clear all
close all
clc;

%input matrix A
A= [35 1 6 26 19 24;3 32 7 21 23 25;31 9 2 22 27 20;8 28 33 17 10 15;30 5 34 12 14 16;4 36 29 13 20 11];
b=[6;2;2;9;0;5];
%create an augment for
M=[A b]
%get the dimension
% nrow - number of rows
% mcol -  number of columns
[nrow, mcol]=size (M);
%forward step
for i=1:nrow
  for j=i:nrow
    printf("substep %d and %d-th row operation \n \r",i,j)
    %this is substep i - j-th row operation
    % detect the pivot row j=i
    %apply row op with pivot row
    if (j==i)
     printf("substep %d - pivot row %d - pivot element %4f\n\r",i,j,M(i,j))
     %check pivot element is different to zeros
     if (M(i,j) !=0)\
       %if pivot is diffent to zeros
       %apply the row op with pivot row
       M(j,:) = M(j,:)/M(j,j);
     else
       printf("Infinite or no solution \r\n")
       %we stop
       break;
     endif
     else
     %case j!=1 - it is not pivot row
     %we eliminate element below pivot element
     M(j,:) = M(j,:) - M(j,i)*M(i,:);
    endif
  endfor
endfor
%back substitution step
%initialize solution x
x=zeros(nrow,1);
%last element of x
x(nrow,1)= M(nrow,mcol);
for i=(nrow-1):-1:1
  x(i,1) = M(i,mcol)- sum(M(i,(i+1):nrow).*x((i+1):nrow,1)');
endfor
x

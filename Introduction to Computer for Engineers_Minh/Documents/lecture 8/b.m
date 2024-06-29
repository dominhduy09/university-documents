clear all
close all
clc;

%input matrix A
A= [3 2 1 1;1 -1 4 -1;-2 -2 -3 1;1 5 -1 2];
%input col vector b
b=[-2;-1;9;4]
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

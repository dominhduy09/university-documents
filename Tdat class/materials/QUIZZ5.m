clear all; clc;
%Set the edge
a=0.4;
b=0.5;
c=0.3;

 %set q, r, s points
q=0*a
r=0.5*b
s=1*c
Indices=[q r s]

t=0.5*a
u=0.5*b
v=(-1)*c
indices=[t u v]

w=0.4*a
n=1*b
m=-0.35*c
[num,den]=rat([0.4 1 -0.35])
A=round([0.4 1 -0.35]*max(den))
INDICES=A

%making the indices into an integer
modres=mod(Indices,1)
if sum(modres)>0
   scale=min(modres(modres >0))
   intIndices=round((1/scale).*Indices)
else
   intIndices=Indices
end

modres=mod(indices,1)
if sum(modres)>0
   scale=min(modres(modres >0))
   intindices=round((1/scale).*indices)
else
   intindices=indices
end

modres=mod(INDICES,1)
if sum(modres)>0
   scale=min(modres(modres >0))
   intINDICES=round((1/scale).*INDICES)
else
   intINDICES=INDICES
end

%plot the Directional Indices
x=[0 intIndices(1)];
y=[0 intIndices(2)];
z=[0 intIndices(3)];

t=[0 intindices(1)];
u=[0 intindices(2)];
v=[0 intindices(3)];

w=[0 intINDICES(1)];
n=[0 intINDICES(2)];
m=[0 intINDICES(3)];

%plot
plot3(x,y,z,'r',t,u,v,'b',w,n,m,'c')
grid
xlabel('x')
ylabel('y')
zlabel('z')
axis([-2 2 -2 2 -2 2])


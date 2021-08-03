TRUNCATE TABLE public.title_basics;
TRUNCATE TABLE public.title_principals;
TRUNCATE TABLE public.title_crew;
TRUNCATE TABLE public.name_basics;
TRUNCATE TABLE public.title_ratings;

--TITLE NAME BASICS
INSERT INTO public.name_basics
(nconst, primaryname, birthyear, deathyear, primaryprofession, knownfortitles)
VALUES('nm1', 'Lauren Bacall', 0, 0, null, null);
INSERT INTO public.name_basics
(nconst, primaryname, birthyear, deathyear, primaryprofession, knownfortitles)
VALUES('nm2', 'Brigitte Bardot', 0, 0, null, null);
INSERT INTO public.name_basics
(nconst, primaryname, birthyear, deathyear, primaryprofession, knownfortitles)
VALUES('nm4', 'Markus Waldow', 0, 0, null, null);
INSERT INTO public.name_basics
(nconst, primaryname, birthyear, deathyear, primaryprofession, knownfortitles)
VALUES('nm5', 'Jennifer Lawrence', 0, 0, null, null);
INSERT INTO public.name_basics
(nconst, primaryname, birthyear, deathyear, primaryprofession, knownfortitles)
VALUES('nm6', 'Kevin Bacon', 0, 0, null, null);


--TITLE BASICS
INSERT INTO public.title_basics
(tconst, titletype, primarytitle, originaltitle, isadult, startyear, endyear, runtimeminutes, genres)
VALUES('tt1', 'short', 'Movie 1', 'One', false, 1985, null, 240, 'Sci-fi,Comedy');
INSERT INTO public.title_basics
(tconst, titletype, primarytitle, originaltitle, isadult, startyear, endyear, runtimeminutes, genres)
VALUES('tt2', 'short', 'Movie 2', 'Two', false, 1985, null, 1, 'Documentary,Short');
INSERT INTO public.title_basics
(tconst, titletype, primarytitle, originaltitle, isadult, startyear, endyear, runtimeminutes, genres)
VALUES('tt3', 'short', 'Movie 3', 'Three', false, 1985, null, 1, 'Comedy,Documentary,Short');
INSERT INTO public.title_basics
(tconst, titletype, primarytitle, originaltitle, isadult, startyear, endyear, runtimeminutes, genres)
VALUES('tt4', 'short', 'Movie 4', 'Four', false, 1985, null, 1, 'Comedy,Documentary,Short');
INSERT INTO public.title_basics
(tconst, titletype, primarytitle, originaltitle, isadult, startyear, endyear, runtimeminutes, genres)
VALUES('tt5', 'short', 'Movie 5', 'Five', false, 1985, null, 1, 'Comedy,Documentary,Short');
INSERT INTO public.title_basics
(tconst, titletype, primarytitle, originaltitle, isadult, startyear, endyear, runtimeminutes, genres)
VALUES('tt6', 'short', 'Movie 6', 'Six', false, 1985, null, 1, 'Comedy,Documentary,Short');


--TITLE PRINCIPALS
INSERT INTO public.title_principals
(tconst, ordering, nconst, category, job, characters)
VALUES('tt1', 1, 'nm1', 'self', null, 'Self');
INSERT INTO public.title_principals
(tconst, ordering, nconst, category, job, characters)
VALUES('tt1', 2, 'nm2', 'self', null, 'Self');

INSERT INTO public.title_principals
(tconst, ordering, nconst, category, job, characters)
VALUES('tt2', 1, 'nm1', 'self', null, 'Self');
INSERT INTO public.title_principals
(tconst, ordering, nconst, category, job, characters)
VALUES('tt2', 2, 'nm2', 'self', null, 'Self');
INSERT INTO public.title_principals
(tconst, ordering, nconst, category, job, characters)
VALUES('tt2', 2, 'nm3', 'self', null, 'Self');

INSERT INTO public.title_principals
(tconst, ordering, nconst, category, job, characters)
VALUES('tt3', 1, 'nm3', 'self', null, 'Self');
INSERT INTO public.title_principals
(tconst, ordering, nconst, category, job, characters)
VALUES('tt3', 2, 'nm4', 'self', null, 'Self');
INSERT INTO public.title_principals
(tconst, ordering, nconst, category, job, characters)
VALUES('tt4', 1, 'nm4', 'self', null, 'Self');
INSERT INTO public.title_principals
(tconst, ordering, nconst, category, job, characters)
VALUES('tt4', 2, 'nm5', 'self', null, 'Self');
INSERT INTO public.title_principals
(tconst, ordering, nconst, category, job, characters)
VALUES('tt5', 1, 'nm5', 'self', null, 'Self');
INSERT INTO public.title_principals
(tconst, ordering, nconst, category, job, characters)
VALUES('tt5', 2, 'nm6', 'self', null, 'Self');



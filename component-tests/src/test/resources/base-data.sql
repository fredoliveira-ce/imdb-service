TRUNCATE TABLE public.title_basics;
TRUNCATE TABLE public.title_principals;
TRUNCATE TABLE public.title_crew;
TRUNCATE TABLE public.name_basics;
TRUNCATE TABLE public.title_ratings;

--TITLE BASICS
INSERT INTO public.title_basics
(tconst, titletype, primarytitle, originaltitle, isadult, startyear, endyear, runtimeminutes, genres)
VALUES('tt1', 'short', 'Back to the Future', 'Back to the Future Original', false, 1985, null, 240, 'Sci-fi,Comedy');
INSERT INTO public.title_basics
(tconst, titletype, primarytitle, originaltitle, isadult, startyear, endyear, runtimeminutes, genres)
VALUES('tt2', 'short', 'Babys Dinner', 'Repas de bébé', false, 1985, null, 1, 'Documentary,Short');
INSERT INTO public.title_basics
(tconst, titletype, primarytitle, originaltitle, isadult, startyear, endyear, runtimeminutes, genres)
VALUES('tt3', 'short', 'Trick Riding', 'La voltige', false, 1985, null, 1, 'Comedy,Documentary,Short');

--TITLE PRINCIPALS
INSERT INTO public.title_principals
(tconst, ordering, nconst, category, job, characters)
VALUES('tt3', 1, 'nm1', 'self', null, 'Self');

--TITLE CREW
INSERT INTO public.title_crew
(tconst, directors, writers)
VALUES('tt1', 'nm2', null);

--TITLE NAME BASICS
INSERT INTO public.name_basics
(nconst, primaryname, birthyear, deathyear, primaryprofession, knownfortitles)
VALUES('nm1', 'Lauren Bacall', 0, 0, null, null);
INSERT INTO public.name_basics
(nconst, primaryname, birthyear, deathyear, primaryprofession, knownfortitles)
VALUES('nm2', 'Brigitte Bardot', 0, 0, null, null);

--TITLE RATINGS
INSERT INTO public.title_ratings
(tconst, averagerating, numvotes)
VALUES('tt1', 6.1, 1674);
INSERT INTO public.title_ratings
(tconst, averagerating, numvotes)
VALUES('tt2', 6.9, 276);
INSERT INTO public.title_ratings
(tconst, averagerating, numvotes)
VALUES('tt3', 6.5, 1169);

# Twitter Filter

Retrieves last tweets that contains some keyword for 30 seconds or up to 100 tweets (whichever comes first) and prints them (tweets grouped by users, both are sorted chronologically ascending). You need to be logged in to Twitter to use the API.

## Example Output

```
$ mvn clean install exec:java
Acquired temporary token...

Go to the following link in your browser:
https://api.twitter.com/oauth/authorize?oauth_token=2idIXwAAAAAAdPF0AAABZ2u0cYU

Please enter the retrieved PIN:
7664953

Authorization was successful


User

ID: 438173498
Creation Date: Fri Dec 16 10:17:59 EET 2011
Screen Name: RadioRagots

Tweets by this user

	ID: 1068982561634959360
	Creation Date: Sun Dec 02 00:37:58 EET 2018
	Text: Hailey Baldwin accro à la chirurgie esthétique à cause du passé entre Justin Bieber et Selena Gomez ? L'étonnante r… https://t.co/VHWae9cCFG


User

ID: 553602594
Creation Date: Sat Apr 14 16:09:13 EEST 2012
Screen Name: lwtasking91

Tweets by this user

	ID: 1068982472887681024
	Creation Date: Sun Dec 02 00:37:36 EET 2018
	Text: RT @soonfelds: Nick Jonas est marié
Justin Bieber est marié
Joe Jonas est fiancé

je me sens tellement vielle, ces mecs je les ai vu gra…


User

ID: 559440920
Creation Date: Sat Apr 21 14:20:57 EEST 2012
Screen Name: soissonschris

Tweets by this user

	ID: 1068982500502978561
	Creation Date: Sun Dec 02 00:37:43 EET 2018
	Text: RT @dandy_cannes: Hailey Baldwin Just Filed to Use the Name 'Hailey Bieber' Commercially https://t.co/m1ibwywd0W #HaileyBaldwin #JustinBieb…


User

ID: 582296429
Creation Date: Thu May 17 03:34:00 EEST 2012
Screen Name: thasantoss16

Tweets by this user

	ID: 1068982543880519682
	Creation Date: Sun Dec 02 00:37:53 EET 2018
	Text: RT @migosjb: justin bieber tinha apenas 16 anos quando ele fez isso  https://t.co/PE1Ma9MxD3


User

ID: 616222444
Creation Date: Sat Jun 23 18:46:35 EEST 2012
Screen Name: saramorrudo

Tweets by this user

	ID: 1068982553430945796
	Creation Date: Sun Dec 02 00:37:56 EET 2018
	Text: RT @migosjb: justin bieber tinha apenas 16 anos quando ele fez isso  https://t.co/PE1Ma9MxD3


User

ID: 702727520
Creation Date: Wed Jul 18 12:28:32 EEST 2012
Screen Name: ohheyitsdeja

Tweets by this user

	ID: 1068982591506788354
	Creation Date: Sun Dec 02 00:38:05 EET 2018
	Text: RT @itsshaylaj: Nigga it took Travis Scott 36 years to drop Astroworld but did his fans give up ? Rihanna completely lost the memory that s…


User

ID: 763128890
Creation Date: Fri Aug 17 09:19:35 EEST 2012
Screen Name: loveMJ3068

Tweets by this user

	ID: 1068982474175336448
	Creation Date: Sun Dec 02 00:37:37 EET 2018
	Text: RT @aaroncarter: By Felicia’s. Your 5 minutes is up. https://t.co/WSN2Za3t5E


User

ID: 1081057262
Creation Date: Fri Jan 11 23:56:50 EET 2013
Screen Name: saraursum

Tweets by this user

	ID: 1068982513983467520
	Creation Date: Sun Dec 02 00:37:46 EET 2018
	Text: RT @AndreaRussett: justin bieber AND nick jonas are married men. 2018 has got to be stopped


User

ID: 1372236560
Creation Date: Mon Apr 22 17:13:16 EEST 2013
Screen Name: CostinhaRJ

Tweets by this user

	ID: 1068982485785161730
	Creation Date: Sun Dec 02 00:37:40 EET 2018
	Text: Só sinto saudades dessa época, dessas músicas. Socorro.


User

ID: 2841047082
Creation Date: Sun Oct 05 12:25:40 EEST 2014
Screen Name: bresap13

Tweets by this user

	ID: 1068982518190403584
	Creation Date: Sun Dec 02 00:37:47 EET 2018
	Text: RT @AndreaRussett: justin bieber AND nick jonas are married men. 2018 has got to be stopped


User

ID: 854461293310423040
Creation Date: Wed Apr 19 01:27:02 EET 2017
Screen Name: thaisdrew462

Tweets by this user

	ID: 1068982592064679936
	Creation Date: Sun Dec 02 00:38:05 EET 2018
	Text: RT @migosjb: justin bieber tinha apenas 16 anos quando ele fez isso  https://t.co/PE1Ma9MxD3


User

ID: 888073464594169856
Creation Date: Thu Jul 20 19:29:48 EET 2017
Screen Name: mollyyy_louise

Tweets by this user

	ID: 1068982520941817858
	Creation Date: Sun Dec 02 00:37:48 EET 2018
	Text: RT @carliaborgen: I never got the chance to be his one less lonely girl 😫 https://t.co/pICznuHyOc


User

ID: 895302872346353664
Creation Date: Wed Aug 09 18:16:53 EET 2017
Screen Name: unapvlvgetiic

Tweets by this user

	ID: 1068982477803479047
	Creation Date: Sun Dec 02 00:37:38 EET 2018
	Text: RT @raphaelEsanchez: I don’t care if he looks like trash, Justin Bieber can still get it.


User

ID: 906546874370478081
Creation Date: Sat Sep 09 18:56:32 EET 2017
Screen Name: MariaClaraAl003

Tweets by this user

	ID: 1068982501790679040
	Creation Date: Sun Dec 02 00:37:43 EET 2018
	Text: RT @migosjb: justin bieber tinha apenas 16 anos quando ele fez isso  https://t.co/PE1Ma9MxD3


User

ID: 906930702649786368
Creation Date: Sun Sep 10 20:21:44 EET 2017
Screen Name: feelsmasoul

Tweets by this user

	ID: 1068982571206418435
	Creation Date: Sun Dec 02 00:38:00 EET 2018
	Text: RT @Iegados: a gente percebe que crescemos quando vê que o Justin bieber casou e o nick Jonas também


User

ID: 959242124838481920
Creation Date: Fri Feb 02 04:48:39 EET 2018
Screen Name: owlobato

Tweets by this user

	ID: 1068982581402787840
	Creation Date: Sun Dec 02 00:38:02 EET 2018
	Text: RT @migosjb: justin bieber tinha apenas 16 anos quando ele fez isso  https://t.co/PE1Ma9MxD3


User

ID: 983787681040789504
Creation Date: Tue Apr 10 22:23:55 EET 2018
Screen Name: Suellen89229773

Tweets by this user

	ID: 1068982591972360192
	Creation Date: Sun Dec 02 00:38:05 EET 2018
	Text: Hoje completa 7 anos do clipe de "All I Want For Christmas Is You" do Justin Bieber com Mariah.


User

ID: 1006807856061042694
Creation Date: Wed Jun 13 10:57:53 EET 2018
Screen Name: vvnott

Tweets by this user

	ID: 1068982580484153344
	Creation Date: Sun Dec 02 00:38:02 EET 2018
	Text: RT @bestpicshb: Mr. &amp; Mrs. Bieber. https://t.co/LMVWn4ph29


User

ID: 1024247423911305217
Creation Date: Tue Jul 31 13:56:30 EET 2018
Screen Name: nichorelloshoe

Tweets by this user

	ID: 1068982509965402112
	Creation Date: Sun Dec 02 00:37:45 EET 2018
	Text: RT @gallablake: found exclusive footage of the musical episode they’re bringing back jasper and getting him to sing justin bieber https://t…


User

ID: 1060526948856815616
Creation Date: Thu Nov 08 16:38:23 EET 2018
Screen Name: blvck98s

Tweets by this user

	ID: 1068982481767067648
	Creation Date: Sun Dec 02 00:37:39 EET 2018
	Text: RT @Groovybiebz: Justin Bieber being inspired and going to the recording studio for 2 days straight, that itself is MUSIC TO MY EARS https:…

Process finished with exit code 0
```

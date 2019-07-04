package rename;

import java.util.List;

import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class Renamer {

	public static int counter = 0;

	public static String[] names = {
		"1000cupcakes", "11Echo", "123marine2", "1panda80", "21texans", "3DS_Triforce", "3rdbaseman4", "459pm",
		"4everfuzzy", "4lphax", "4sordy", "77chainblade", "99milzman", "Aaron_Rainthief", "ABQiu", "absthatsme",
		"abysmus", "abzilla", "acidsin", "acraftybugger", "adambuss", "adampoconnor", "adamzetti", "adolia",
		"driedupleaf", "Aerinyes", "aetherandnether", "AFRICA", "aidanrocks25", "ailbhlaffe", "Ainieve",
		"Akathepriest", "Alec97531", "alecf731", "alexryanb", "alexthecoolmac", "Alizatina", "Allyvand1497",
		"alphaelf", "Amortik1996", "Anactofgod", "andrewf731", "Andy586", "AndyWestside", "angrysquirlz",
		"Anhysbys", "Anthony423", "antz666", "aperry1993", "ApocalyqseNow", "Aqua2iK", "aqwshalew3", "ArinaChan23",
		"Armydude101", "Artemis315", "Artemis_En", "articuno96", "asbo96", "Ashmen", "asmith307", "aTbagger",
		"atlanta0", "atyl95", "AustinSpiers", "Avengeline", "Awdie", "AwesomeDude728", "AwesomeGuy900",
		"awesomeguy911", "Awsomr00", "ayrtonchin", "Azasimus", "azureheights", "B1GBADW0IF", "b777all",
		"babyface0519", "bailout00", "baller111", "Banaynay", "bandrew97", "Barbaric_Emu", "basstardee", "Batyote",
		"Bball_Star", "bbrooks066", "Belaneth", "Ben952", "Benben582", "Benn_Benn", "benpowell987", "bevo00",
		"bgeaman", "Bigalow40", "BigGojira", "BigKid_Icarus", "BigLlama", "BigMucho", "Bigtimewinner", "BIG_Quakez",
		"birdman15", "birdy9", "bizznchriz", "Bkettell", "bkwopper", "blackdust79", "blackfire9z", "blackhawk77g",
		"blackouTT", "blackstorm58", "blake11120", "BlastedFool", "blazindonuts824", "BleakBear", "bleh337",
		"Blimm", "Blitzfitz", "BlockedShots", "Bloodlest", "Bloodnight", "Bloodtyl", "blurrdew", "bluzekluze",
		"bmanpyro", "BMXBikes58", "bob20163", "bob6199", "bobbshields", "Boborito71", "booglee322", "bookboy123",
		"bootgamer5", "boriater", "Boss_Pro", "bowledd", "boxofspiderss", "BoxPuncher", "brampel", "brancher",
		"brandt2846", "Braxis", "BrianOwennn", "BRISKET", "broadsword123", "brobot222", "BroncoBuster25",
		"BrookesGirl", "brycecameron", "BrylieGirl", "bsams5", "BTechnique", "BTT8", "bubabang12", "budro1111",
		"BugsyH", "buildingharry", "BullSabu", "bumscracher", "Bumz", "Burblessnot", "Burkester", "busynarcissist",
		"butnuf34", "Buwario", "bwanoodles009", "C00LMAN123", "C375", "Caffeine__Addict", "calin99", "CaptainMC",
		"captinbaer1", "caseyk1105", "catus123", "cboychuk", "cdog123456789", "cdonovan", "cdown13", "Celeress",
		"cfurn5", "ch0c0lat3man", "chall63461", "Chatelaine", "chazzam14", "cheatster989", "cheesyboy2011",
		"chengkaijie9999", "cherry1029384756", "Chewiebonez", "Chicken1219", "chickenpress75", "ChiCken_Ledel",
		"Chicotheman94", "Chieftainy", "Childflayer", "chingchong401", "chocolatier1991", "choy17", "Chris7692",
		"Chrisamerica", "chrisk11", "Chrustee96", "ChubberMummaBoy", "chumsly", "Chunnnky", "Cidith", "clampet",
		"clayqtpie", "CloakandDagger", "clocke13", "codepsilon", "codyneace", "Coecoepuff2", "cometking123",
		"CommanderCooley", "conman167", "connerk7", "connorr1", "coolguy399", "Cooner003", "cowsgopoo",
		"craftermagicman", "CraftinMaster117", "Craftking11", "crazy02chris", "CrazyBlueBannana", "Crazybrother",
		"crazyjake123", "crazziecanuck", "Creeper_asylum", "Crianade", "CrimsonYoshi", "cronocio", "CrowCard",
		"crystalballmac", "CTTheSchism", "CybrKrystlz", "c_kitai306", "daanisjaap", "DaFlash32", "Daggtex",
		"Dahbakon", "daimond84", "dakmech9", "Dalewayward", "damage78930", "DamonKBrown", "dan2510", "Dangime",
		"daniel77677", "danielgergely", "dannybtran", "DaOldMan", "darianngo", "DarioRVa", "darker1126",
		"darkmind9999", "darkradience", "DarkSoundwave", "Darkstorm969", "DarkValkare", "Darkwolf524", "Darstidos",
		"Dave5483", "davidnator123", "Dayne25", "DA_BLOOP", "DBreformed479", "DCXK", "DeadDew", "deadlydent101",
		"deadlytiger1", "DeadManJ0e13", "DeathAdder95", "Deathbreak911", "deathgodichigo", "deathmetalcop",
		"DeathNWar", "DecoLamb", "DecoyDebbie", "deimian254", "Delta_22", "deniz_696", "Denken_Polizei", "Deruip",
		"desmin88", "DesmodusDantre", "DeSzTr0y3r", "Detharein", "Deungo", "dewhickey", "deyjvcfg",
		"diamond_tycoon", "dibo", "Dieheart", "dilliwig", "Dillon1975", "Dimbulb", "Divine_Nightmare",
		"Dizzysquirrl", "DJ08", "DJParker", "djpremire", "dkdude2", "domino255", "DonaldDuckMG42", "donersayshi",
		"doombugy", "doorman143", "dragomaster69", "DragonHeart00", "DrDemocracy", "Dreadcor", "Dregamus",
		"DrRaptor", "Dr_Lyle", "duddlypuppy", "Dudesyaswhat1011", "DukeTop", "duramon", "dustangel4109",
		"Dwalsh896", "Dy1_", "dynamite4477", "earnhart2000", "Earthquick1998", "EaTFresH1o1", "elderzeth",
		"elmo2cake", "Elmotookmybaby", "elricofmelnibone", "el_gordo_uno", "emanuelllamas", "Eminence_k",
		"Ender6600", "energester", "EnLight707", "enozservant", "Epicelia", "Erazz94", "erikus6", "ert396", "Eruza",
		"espike7", "Ethdir", "Ever", "evilevan82", "Evilope", "Exacto23", "explosivebma", "Extreats",
		"FacelessPsych0", "failedreality", "FakeTruth", "fatiandog1234", "FazyTazyTraLaLa", "FeatheredSun",
		"Feinyth", "festivemaster", "FierceShadow", "Firebody", "firespirit44", "Fistbumps", "flashfire6970",
		"FlogtheInfidel", "flyers77", "foreverawalrus", "ForkliftsFTW", "fourthbrook", "foxhull", "foxxy2112",
		"FpsSkiller", "FraserK", "FRE3DOM_FIGHT3R", "FreckleDew", "Frenchy1", "friday593", "frodew", "frogface99",
		"FSUISBACK2011", "Fuego_Tortuga", "fullmetal2000", "gaara1125", "GabeSyFy", "gaddo_man", "GaidenFocus",
		"gaiusmarius8", "gamedude113", "gamer4526", "gamerphate", "Gamma_Gamer54", "Garet867", "garrettmc18",
		"Gastronam", "gavinmax88", "gemondkid", "GeneralDamras", "GeneralKash", "george0106", "georgege1229",
		"GerkJerk", "ggt3416", "ggteixeira", "Gibbusflame", "Gigglegasm", "Giizmo", "GirlyDuty", "Godfather5866",
		"Godock2006", "GodOfSquirrels", "Goldblade02", "goldenknight88", "Goldrim", "Gozar", "GreatBandit",
		"Greek2me", "greenienator", "GreenWins", "greenwolf25", "Gregzilla83", "Groobs03", "GrrGrrzap",
		"Gu1t4r_M4n", "guitar8293", "guitarisepic", "Gumat", "gunsbeforeroses", "Guswut", "gw4", "gwilson3",
		"H3artsD3ath", "hacchan30", "haggispantsrules", "Hallway_Monitor", "halodude24", "happypaintard",
		"HarrisonBitzis", "Hathegkla", "hawaii727", "Hazardless", "HeartoftheMoon", "hector678", "heiwashin",
		"HelioCentrick", "Helio_", "helthron", "henmo97", "heromouse", "Hexavolt", "higgyl", "Hightinker",
		"hollabro", "Hollure", "HOneYDeWZ17", "hotdudelet", "hubey2", "hudson1", "Hudsonhull", "huntermhaxx",
		"Iamdead1", "icecream26001", "ichiimaru77", "iCreepersGoBoom", "IcySoul", "icystealth62", "ihelploserface",
		"iKanak", "imthelag", "inimrepus", "Inp_Alive", "inuyashaman3", "Ipuntbabyz", "ironhyde", "IrwinKerwin",
		"iSaffy", "iScherf", "Issac332", "iTater", "iThe_Disciple", "ItzDarklord", "IwoveYU", "I_Do_It", "J0sh23",
		"Jackertud", "Jackson223", "jacobmorgs", "jadenx2000", "Jake12121", "jake70", "JakeKorney", "JCDamian10",
		"jcolby99", "JCQuiinn", "jdididydog", "JDSnuff", "Jenkks", "jennmanahan", "jeremysee", "jimbo310",
		"JimBouki", "Jimboy135", "jimfalcon", "JimmyTo781", "JJ1988", "jjd712", "jmart85", "joejoebeef",
		"joethecrow", "joey_dev", "joleegirl", "Jordan09", "Jordycooldude", "joshdell2001", "Joshua422",
		"Josiah_Farrell", "joyjumper", "jshreder", "jtringl", "juniorboyd", "JUNKYARD129FAN", "justjberg",
		"JustSeth", "Just_so_epic", "jwbbman", "kadenson", "kadoro", "Kage_of_UF", "KainBullet", "kaleehma",
		"KaptKang", "kasrith", "Kassial", "Katashi_Ezora", "kaylee_ference", "kc776", "keithr1", "Kekens",
		"kell608", "kelp07", "Ken_McG", "kernaleugene", "keseyj96", "kevinf5", "KevinX000", "killbot11",
		"killer52698", "killerwolfy1", "killerzapmaster", "kimsoroxlol", "KindaSpacey", "kingerpy",
		"kingkongsasasin", "KingMark", "Kingpixels", "kiwi6", "kkaionsg", "KkSoso", "klanz", "Kleebop", "klevin",
		"kley1313", "Knowledge519", "kokobrainz", "KonanXD", "Kong999", "Konseince", "Korblox1134", "kornfarmer",
		"Korvic", "kotasuperhero", "KrayzieJ", "KrispyKslave", "Krusher548", "ktish", "ktran253", "kumilightbulb",
		"Kumpass_dodo", "Kumpass_Skater", "kylearmy", "L4YT0N", "Lachie1020", "Lady_Scarlet", "Latnem",
		"Lava_soldier", "lbvermillion", "LDSFlame", "Leafreo", "Leetskillz", "lekin680810", "lekrog", "lennon8467",
		"LeoFerari", "LexiBooHoo", "Lgiteco", "Lightbikemaster", "lilbuddhaman", "lilprplebnny", "lilymunroe",
		"Lil_Ch00b", "limeyman7", "lindsayboulanger", "LittleFirestar", "LittleMidget17", "llcyanidell",
		"Lleonidass", "Lockewiggen", "lodada1", "LokiTwoSpirit", "Lokthar328i", "LOLeannie", "Loliotaku",
		"LoneTonberry", "LootieLoo", "lora_snelson", "LordOTheSigns", "LoveGunner", "LOVETHEWHITE", "Lowen_Brau",
		"lucisiac", "LuckyChams", "M0nstrosity", "macmorris92", "madon47", "MadxRad", "mageg", "magicman112233",
		"MagmaDragon12", "Magyckmage25", "mag_wraith", "majam", "Major_Mayjor", "manjiggler", "MarcoTheItalian",
		"MarieC90", "marshall3128", "martinez9", "masacardi", "masterw3", "matharama", "matt321123", "mattheus02",
		"mattyhastheforce", "Maverick_Beast", "maxrage", "maxxxafterhours", "mcarchitect22", "McGruber78",
		"McMichael96", "mcotterman", "mdc0923", "MELICENT", "meltedcup", "mercury199", "metalpants2",
		"MetroRoadWarrior", "Mewlver82", "Mezua", "MGBroadcast", "mhayes3", "midnightchan123", "Mikejuju1",
		"mikey14", "Mimmy99", "MineMyles", "miner49burr", "minerman183", "Miner_Nick_M", "Mingpow321",
		"Misterz_Noodles", "Mitchsmom", "MjCbse", "mlp94", "mmitchell9", "Mobsterguy", "ModernDragoness",
		"monkeybidness", "MooMooutters", "moosehunter123", "morgan2041", "MortalWombat88", "MosesT", "motown2003",
		"Mouei", "mowat40", "mrbaconbitts", "MrBlahblah", "MrDragonBreath", "MrPumpkinMuffins", "MrSquirrelMan",
		"Mr_Boomer337", "MR_RANDOM999", "Mr_SneakyFace", "Mr_Sterling", "msbrun02", "mtndrew1", "Muddha",
		"MuffinOfFun", "MuffinSpankz", "murderrr", "murdock99", "myers121", "mylimo7", "myminecraftnow",
		"mysticmock", "Mystronghold", "M_Boogie_C", "nacho30", "nanderson17", "Narcisism", "Navia", "nbc0711",
		"NeilYoung", "nemaster203", "nerdnut", "nerraj", "nevermines", "newmatt003", "Nexun", "ngennaro",
		"NICFREAK5577", "nicilbar", "Nick_O_Shlas", "Nighthawk354", "NightmareV", "Nikkisweety", "ninjaboy6728",
		"NinjaElite71", "nleroy", "nobrain98", "NoglasticNinja", "noisymanray", "nolarboot", "noob_cat",
		"Noproblembrah", "Noresha", "nosnarbo", "novak189", "nr88hg", "nubkia", "Nyntoku", "Nzgbjunior",
		"obfalcons", "ObiWanHoshizaki", "ogot101", "ojpnobeast", "oK9power", "Old_Ninja", "OllyWilliams",
		"oMasterCole", "omegasnab1"
	};

	public void renameMethod(GuildMessageReceivedEvent e) {

		e.getChannel().sendMessage("began working").queue();

		List<Member> members = e.getGuild().getMembers();

		for (Member member : members) {

			if (member.getUser().getAvatarUrl() == null
					&& !e.getMember().getUser().getId().equals("538933187817111562")) {

				try {

					String nick = names[counter];
					e.getGuild().getController().setNickname(member, nick).queue();
					counter++;
					System.out.println(nick + " has been modified");

				} catch (Exception ex) {

					System.err.println("Error " + member.getUser().getName());

				}

			}

		}

	}

}

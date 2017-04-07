package in.ac.mjcet.mjconnect.Utils;

import java.util.ArrayList;
import java.util.HashMap;

public class Subject{

	String id;
	String name;
	private static HashMap<String, ArrayList<Subject>> subjectHashMap;
	public Subject(String id, String name){
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}

	public static HashMap<String,ArrayList<Subject>> getSubjectHashMap(){

		if(subjectHashMap != null){
			return subjectHashMap;
		}
	HashMap<String,ArrayList<Subject>> subject = new HashMap<>();

	ArrayList<Subject> firstYear = new ArrayList<Subject>();
	firstYear.add(new Subject("CH101", "Engineering Chemistry"));
	firstYear.add(new Subject("CE102", "Engineering Graphics"));
	firstYear.add(new Subject("CE101", "Engineering Mechanics"));
	firstYear.add(new Subject("PH101", "Engineering Physics"));
	firstYear.add(new Subject("EN101", "English"));
	firstYear.add(new Subject("MT101", "Mathematics-I"));
	firstYear.add(new Subject("MT102", "Mathematics-II"));
	firstYear.add(new Subject("MT102", "Programing in C & C++"));

	subject.put("1",firstYear);

	ArrayList<Subject> CSE21 = new ArrayList<Subject>();

	CSE21.add(new Subject("MT201", "Mathematics-III"));
	CSE21.add(new Subject("CS201", "Data Structures Using C++"));
	CSE21.add(new Subject("CS202", "Discrete Structures"));
	CSE21.add(new Subject("CS203", "Logic And Switching Theory"));
	CSE21.add(new Subject("CS204", "Computer Architecture"));
	CSE21.add(new Subject("EC222", "Basic Electronics"));

	subject.put("cse21",CSE21);

	ArrayList<Subject> CSE22 = new ArrayList<Subject>();

	CSE22.add(new Subject("MT251", "Mathematics-IV"));
	CSE22.add(new Subject("CS251", "Object Oriented Programming Using JAVA"));
	CSE22.add(new Subject("CS252", "Microprocessors And Interfacing"));
	CSE22.add(new Subject("EE221", "Electrical Circuits And Machines"));
	CSE22.add(new Subject("CS253", "Principles Of Programming Languages"));
	CSE22.add(new Subject("CE222", "Environmental Studies"));

	subject.put("cse22",CSE22);

	ArrayList<Subject> CSE31 = new ArrayList<Subject>();

	CSE31.add(new Subject("CS301", "Database Managemnet Systems"));
	CSE31.add(new Subject("CS302", "Operating Systems"));
	CSE31.add(new Subject("CS303", "Automata, Languages And Compliation"));
	CSE31.add(new Subject("CS304", "Software Engineering"));
	CSE31.add(new Subject("CM371", "Managerial Economics And Accountancy"));
	CSE31.add(new Subject("CS306", "Data Communications"));

	subject.put("cse31",CSE31);

	ArrayList<Subject> CSE32 = new ArrayList<Subject>();

	CSE32.add(new Subject("CS351", "Web Programming And Services"));
	CSE32.add(new Subject("CS352", "Complier Constructions"));
	CSE32.add(new Subject("CS356", "Design And Analysis Of Algorithms"));
	CSE32.add(new Subject("CS354", "Object Oriented System Development"));
	CSE32.add(new Subject("CS355", "Computer Networks"));

	subject.put("cse32",CSE32);

	ArrayList<Subject> CSE41 = new ArrayList<Subject>();

	CSE41.add(new Subject("CS401", "Distributed Systems"));
	CSE41.add(new Subject("CS402", "Artificial Intelligence"));
	CSE41.add(new Subject("CS403", "Information Security"));
	CSE41.add(new Subject("CS404", "Principles And Applications Of Embedded Systems"));
	CSE41.add(new Subject("CS411", "Software Project Management (Elective – I)"));
	CSE41.add(new Subject("CS412", "Computer Graphics (Elective – I)"));
	CSE41.add(new Subject("CS413", "Image Processing (Elective – I)"));
	CSE41.add(new Subject("CS414", "Adhoc And Sensor Networks (Elective – I)"));
	CSE41.add(new Subject("CS415", "Soft Computing(Elective – I)"));
	CSE41.add(new Subject("CS416", "Mobile Computing (Elective – I)"));
	CSE41.add(new Subject("CS417", "Real Time Systems (Elective-I)"));
	
	subject.put("cse41",CSE41);
	
	ArrayList<Subject> CSE42 = new ArrayList<Subject>();

	CSE42.add(new Subject("CS451", "Data Mining"));
	CSE42.add(new Subject("CS461", "Simulation & Modeling (Elective – II)"));
	CSE42.add(new Subject("ME404", "Operation Research (Elective – II)"));
	CSE42.add(new Subject("CS463", "Software Quality And Testing (Elective – II)"));
	CSE42.add(new Subject("CS464", "Information Storage And Management (Elective – II)"));
	CSE42.add(new Subject("CS465", "Human Computer Interaction (Elective – II)"));
	CSE42.add(new Subject("CS466", "Software Reuse Techniques (Elective - II)"));
	CSE42.add(new Subject("ME411", "Entrepreneurship (Elective – II)"));
	CSE42.add(new Subject("CS471", "Information Retrieval Systems (Elective – III)"));
	CSE42.add(new Subject("CS472", "Semantic Web (Elective – III)"));
	CSE42.add(new Subject("LA454", "Intellectual Property Rights (Elective – III)"));
	CSE42.add(new Subject("CS474", "Advanced Databases (Elective – III)"));
	CSE42.add(new Subject("CS475", "Multimedia Systems (Elective – III)"));
	CSE42.add(new Subject("CS476", "Cloud Computing Computing(Elective-III)"));
	CSE42.add(new Subject("CS452", "Disaster Management (Elective - III)"));

	subject.put("cse42",CSE42);


	ArrayList<Subject> CIV21 = new ArrayList<Subject>();

	CIV21.add(new Subject("MT201", "Mathematics-III"));
	CIV21.add(new Subject("CE201", "Building Drawing"));
	CIV21.add(new Subject("CE202", "Discrete Structures"));
	CIV21.add(new Subject("CE203", "Engineering Geology"));
	CIV21.add(new Subject("CE204", "Strength Of Materials - I"));
	CIV21.add(new Subject("CE205", "Surveying - I"));

	subject.put("civil21",CIV21);

	ArrayList<Subject> CIV22 = new ArrayList<Subject>();

	CIV22.add(new Subject("CE251", "Strength Of Materials – II"));
	CIV22.add(new Subject("CE252", "Surveying - II"));
	CIV22.add(new Subject("CE253", "Fluid Mechanics – I "));
	CIV22.add(new Subject("CE222", "Environmental Studies"));
	CIV22.add(new Subject("EE271", "Electrical Technology – I"));
	CIV22.add(new Subject("ME271", "Electrical Technology – II"));

	subject.put("civil22",CIV22);

	ArrayList<Subject> CIV31 = new ArrayList<Subject>();

	CIV31.add(new Subject("CE301", "Reinforced Cement Concrete"));
	CIV31.add(new Subject("CE302", " Fluid Mechanics – II"));
	CIV31.add(new Subject("CE303", "Theory Of Structures – I "));
	CIV31.add(new Subject("CE304", "Building Technology And Services"));
	CIV31.add(new Subject("CE305", "Transportation Engineering"));
	CIV31.add(new Subject("CM371", "Managerial Economics And Accountancy"));

	subject.put("civil31",CIV31);

	ArrayList<Subject> CIV32 = new ArrayList<Subject>();

	CIV32.add(new Subject("CE351", "Soil Mechanics"));
	CIV32.add(new Subject("CE352", "Steel Structures"));
	CIV32.add(new Subject("CE353", "Theory Of Structures – II "));
	CIV32.add(new Subject("CE354", "Structural Engg. – Design & Detailing – I (RCC)"));
	CIV32.add(new Subject("CE355", "Water Resources Engg. And Management – I"));
	CIV32.add(new Subject("CE356", "Water And Waste Water Engineering"));

	subject.put("civil32",CIV32);

	ArrayList<Subject> CIV41 = new ArrayList<Subject>();

	CIV41.add(new Subject("CE401", "Structural Engineering Design And Detailing –II(Steel)"));
	CIV41.add(new Subject("CE402", "Estimating And Specifications"));
	CIV41.add(new Subject("CE403", "Foundation Engineering "));
	CIV41.add(new Subject("CE404", "Water Resources Engineering And Management – II"));
	CIV41.add(new Subject("CE405", "Concrete Technology"));
	CIV41.add(new Subject("CE406", "Elements Of Earthquake Engineering (Elective-I)"));
	CIV41.add(new Subject("CE407", "Surface And Ground Water Management (Elective-I)"));
	CIV41.add(new Subject("CE408", "Pre-Stressed Concrete (Elective –I)"));
	CIV41.add(new Subject("CE409", "Geographical Information Systems (Elective – I)"));
	CIV41.add(new Subject("ME404", "Operation Research In Civil Engineering(Elective-I)"));
	CIV41.add(new Subject("ME411", "Entrepreneurship"));

	subject.put("civil41",CIV41);

	ArrayList<Subject> CIV42 = new ArrayList<Subject>();

	CIV42.add(new Subject("CE451", "Construction Management And Administration"));
	CIV42.add(new Subject("CE452", "Disaster Mitigation And Management"));
	CIV42.add(new Subject("CE453", "Health Monitoring And Retrofitting Of Structures (Elective-II) "));
	CIV42.add(new Subject("CE454", "Ground Improvement Techniques (Elective –II)"));
	CIV42.add(new Subject("CE455", "Advanced Environmental Engg. (Elective – II)"));
	CIV42.add(new Subject("CE456", "Advanced Reinforced Concrete Design (Elective –II)"));
	CIV42.add(new Subject("CE457", "Advanced Transportation Engg. (Elective –III)"));
	CIV42.add(new Subject("CE458", "Ground Water Hydrology (Elective – III)"));
	CIV42.add(new Subject("CE459", "Finite Element Method (Elective –III)"));
	CIV42.add(new Subject("CE460", "Infrastructure Engineering"));
	CIV42.add(new Subject("CE403", "Information Security"));
	CIV42.add(new Subject("LA454", "Intellectual Property Rights (Elective –III)"));

	subject.put("civil42",CIV42);

	ArrayList<Subject> ECE21 = new ArrayList<Subject>();

	ECE21.add(new Subject("MT201", "Mathematics-III"));
	ECE21.add(new Subject("EC201", "Basic Circuits Analysis"));
	ECE21.add(new Subject("EC202", "Electomagnetic Theory"));
	ECE21.add(new Subject("EC203", "Electronic Devices"));
	ECE21.add(new Subject("ME221", "Elements Of Mechanical Engineering"));
	ECE21.add(new Subject("EC222", "Electrical Technology"));

	subject.put("ece21",ECE21);

	ArrayList<Subject> ECE22 = new ArrayList<Subject>();

	ECE22.add(new Subject("MT251", "Mathematics-IV"));
	ECE22.add(new Subject("EC251", "Analog Electronic Circuits"));
	ECE22.add(new Subject("EC252", "Networks And Transmission Lines"));
	ECE22.add(new Subject("EC253", "Signal Analyis And Transform Techniques"));
	ECE22.add(new Subject("EC254", "Pulse, Digital And Switching Circuits"));
	ECE22.add(new Subject("CE225", "Environmental Studies"));

	subject.put("ece22",ECE22);

	ArrayList<Subject> ECE31 = new ArrayList<Subject>();

	ECE31.add(new Subject("EC301", "Linear Integrated Circuits And Applications"));
	ECE31.add(new Subject("EC302", "Pulse And Digital Circuits"));
	ECE31.add(new Subject("EC303", "Analog Communications"));
	ECE31.add(new Subject("EC304", "Automatic Control Systems"));
	ECE31.add(new Subject("EC305", "Computer Organization And Architecture"));
	ECE31.add(new Subject("EC306", "Digital System Design And With VERILOG HDL"));

	subject.put("ece31",ECE31);

	ArrayList<Subject> ECE32 = new ArrayList<Subject>();

	ECE32.add(new Subject("EC351", "Digital Communications"));
	ECE32.add(new Subject("EC352", "Digital Signal Processing"));
	ECE32.add(new Subject("EC353", "Antennas And Propagation"));
	ECE32.add(new Subject("EC354", "Microprocessors And Microcontrollers"));
	ECE32.add(new Subject("CM371", "Managerial Economics And Accountancy"));

	subject.put("ece32",ECE32);

	ArrayList<Subject> ECE41 = new ArrayList<Subject>();

	ECE41.add(new Subject("EC401", "Microwave Engineering"));
	ECE41.add(new Subject("EC402", "VLSI Design"));
	ECE41.add(new Subject("EC403", "Computer Networks"));
	ECE41.add(new Subject("EC404", "Mobile Cellular Communication"));
	ECE41.add(new Subject("EC472", "Industrial Administration And Financial Management"));
	ECE41.add(new Subject("EC411", "Embedded Systems"));
	ECE41.add(new Subject("EC412", "Optical Fiber Communication"));
	ECE41.add(new Subject("EC413", "Digital Image Processing"));
	ECE41.add(new Subject("EC414", "Multi Rate Signal Processing"));
	ECE41.add(new Subject("EC415", "System Automation And Control"));
	ECE41.add(new Subject("CS403", "Information Security"));

	subject.put("ece41",ECE41);

	ArrayList<Subject> ECE42 = new ArrayList<Subject>();

	ECE42.add(new Subject("EC451", "Radar And Satellite Communication Systems"));
	ECE42.add(new Subject("EC461", "Real Time Operating Systems"));
	ECE42.add(new Subject("EC462", "Coding Theory And Techniques"));
	ECE42.add(new Subject("EC463", "Design Of Fault Tolerant Systems"));
	ECE42.add(new Subject("EC464", "Speech Processing"));
	ECE42.add(new Subject("EC465", "Wireless Sensor Networks"));
	ECE42.add(new Subject("ME411", "Entrepreneurship"));
	ECE42.add(new Subject("EC471", "Nano Technology"));
	ECE42.add(new Subject("EC472", "Global Positioning Systems"));
	ECE42.add(new Subject("EC473", "Neural Networks And Fuzzy Logic"));
	ECE42.add(new Subject("EC474", "Spectral Estimation Techniques"));
	ECE42.add(new Subject("LA454", "Intellectual Property Rights"));
	ECE42.add(new Subject("CE452", "Disaster Mitigation And Management"));

	subject.put("ece42",ECE42);

	ArrayList<Subject> EEE21 = new ArrayList<Subject>();

	EEE21.add(new Subject("MT201", "Mathematics-III"));
	EEE21.add(new Subject("EE201", "Electrical Circuits – I"));
	EEE21.add(new Subject("CE222", "Environmental Studies"));
	EEE21.add(new Subject("EE204", "Electrical Measurements And Instruments"));
	EEE21.add(new Subject("EC221", "Electronic Engineering – I"));
	EEE21.add(new Subject("ME221", "Principles Of Mechanical Engineering"));

	subject.put("eee21",EEE21);

	ArrayList<Subject> EEE22 = new ArrayList<Subject>();

	EEE22.add(new Subject("EE251", "Electrical Circuits – II"));
	EEE22.add(new Subject("CE223", "Solid Mechanics"));
	EEE22.add(new Subject("EE271", "Power Systems-I"));
	EEE22.add(new Subject("EC271", "Electronic Engineering – II"));
	EEE22.add(new Subject("EE252", "Electromagnetic Theory"));
	EEE22.add(new Subject("EE254", "Electrical Machinery – I"));

	subject.put("eee22",EEE22);

	ArrayList<Subject> EEE31 = new ArrayList<Subject>();

	EEE31.add(new Subject("EE301", "Power Systems – I"));
	EEE31.add(new Subject("EE302", "Electrical Machinery – II"));
	EEE31.add(new Subject("EE303", "Power Electronics"));
	EEE31.add(new Subject("EE304", "Digital Electronics And Logic Design"));
	EEE31.add(new Subject("EE305", "Linear Integrated Circuits"));
	EEE31.add(new Subject("EE306", "Linear Control Systems"));

	subject.put("eee31",EEE31);

	ArrayList<Subject> EEE32 = new ArrayList<Subject>();

	EEE32.add(new Subject("EE351", "Digital Signal Processing"));
	EEE32.add(new Subject("EE352", "Electrical Machinery – III"));
	EEE32.add(new Subject("EE353", "Switchgear And Protection"));
	EEE32.add(new Subject("EE354", "Microprocessors And Microcontrollers"));
	EEE32.add(new Subject("CM371", "Managerial Economics And Accountancy"));

	subject.put("eee32",EEE32);

	ArrayList<Subject> EEE41 = new ArrayList<Subject>();

	EEE41.add(new Subject("EE401", "Power System Operation And Control"));
	EEE41.add(new Subject("EE402", "Electric Drives And Static Control"));
	EEE41.add(new Subject("EE403", "Electronic Mechine Design"));
	EEE41.add(new Subject("EE411", "High Voltage DC Transmission (Elective – I)"));
	EEE41.add(new Subject("EE412", "High Voltage Enginnering (Elective – I)"));
	EEE41.add(new Subject("EE413", "Power Quality (Elective – I)"));
	EEE41.add(new Subject("EE414", "Nuclear Energy (Elective – I)"));
	EEE41.add(new Subject("ME411", "Entrepreneurship"));
	EEE41.add(new Subject("EE403", "Information Security(Elective – I)"));
	EEE41.add(new Subject("CS467", "Embedded Systems"));

	subject.put("eee41",EEE41);

	ArrayList<Subject> EEE42 = new ArrayList<Subject>();

	EEE42.add(new Subject("EE451", "Utilization"));
	EEE42.add(new Subject("ME472", "Industrial Administration And Financial Management"));
	EEE42.add(new Subject("EE461", "Electrical Power Distribution Engineering (Elective – II)"));
	EEE42.add(new Subject("EE462", "Advanced Control Systems (Elective – II)"));
	EEE42.add(new Subject("EE463", "Optimization Methods (Elective – II)"));
	EEE42.add(new Subject("EC402", "VLSI DESIGN"));
	EEE42.add(new Subject("LA454", "Intellectual Property Rights (Elective –II)"));
	EEE42.add(new Subject("CE452", "DIASTER MITIGATION MANAGEMENT"));
	EEE42.add(new Subject("EE471", "Renewable Energy Sources (Elective – II)"));
	EEE42.add(new Subject("EE472", "Transducers"));
	EEE42.add(new Subject("EE473", "Power System Reliability (Elective – III)"));
	EEE42.add(new Subject("EE452", "Electronic Instrumentation Systems (Elective-III)"));
	EEE42.add(new Subject("CS413", "Image Processing (Elective – III)"));
	EEE42.add(new Subject("CS415", "Soft Computing (Elective – III)"));

	subject.put("eee42",EEE42);

	ArrayList<Subject> MECH21 = new ArrayList<Subject>();

	MECH21.add(new Subject("MT201", "Mathematics-III"));
	MECH21.add(new Subject("ME201", "Metallurgy And Material Science"));
	MECH21.add(new Subject("ME202", "Machine Drawing"));
	MECH21.add(new Subject("CE221", "Mechanics Of Materials"));
	MECH21.add(new Subject("CE222", "Environmental Studies"));
	MECH21.add(new Subject("CM221", "Managerial Economics And Accountancy"));

	subject.put("mech21",MECH21);

	ArrayList<Subject> MECH22 = new ArrayList<Subject>();

	MECH22.add(new Subject("MT251", "Mathematics-IV"));
	MECH22.add(new Subject("ME251", "Kinematics Of Machines"));
	MECH22.add(new Subject("EE221", "Electrical Circuits And Machines"));
	MECH22.add(new Subject("ME253", "Thermo Dynamics"));
	MECH22.add(new Subject("EC272", "Applied Electronics"));
	MECH22.add(new Subject("CE271", "Fluid Dynamics"));

	subject.put("mech22",MECH22);

	ArrayList<Subject> MECH31 = new ArrayList<Subject>();

	MECH31.add(new Subject("ME301", "Applied Thermodynamics"));
	MECH31.add(new Subject("ME302", "Dynamics Of Machines"));
	MECH31.add(new Subject("ME303", "Design Of Machine Elements"));
	MECH31.add(new Subject("ME304", "Hydraulic Machinery And System"));
	MECH31.add(new Subject("ME305", "Manufacturing Process"));

	subject.put("mech31",MECH31);

	ArrayList<Subject> MECH32 = new ArrayList<Subject>();

	MECH32.add(new Subject("ME351", "Machine Design"));
	MECH32.add(new Subject("ME352", "Metal Cutting And Machine Tool Engineering"));
	MECH32.add(new Subject("ME353", "CAD/CAM"));
	MECH32.add(new Subject("ME354", "Heat Transfer"));
	MECH32.add(new Subject("ME355", "Control Systems"));
	MECH32.add(new Subject("ME356", "Refrigeration And Air Conditioning"));

	subject.put("mech32",MECH32);

	ArrayList<Subject> MECH41 = new ArrayList<Subject>();

	MECH41.add(new Subject("ME401", "Thermal Turbo Machines"));
	MECH41.add(new Subject("ME402", "Metrology And Instrumentation"));
	MECH41.add(new Subject("ME403", "Finite Element Analysis"));
	MECH41.add(new Subject("ME404", "Operations Research"));
	MECH41.add(new Subject("ME406", "Neural Networks"));
	MECH41.add(new Subject("ME407", "Automobile Engineering"));
	MECH41.add(new Subject("ME408", "Non Conventional Energy Sources"));
	MECH41.add(new Subject("ME409", "Tool Design"));
	MECH41.add(new Subject("ME411", "Entrepreneurship"));
	MECH41.add(new Subject("ME412", "Computational Fluid Flows"));
	MECH41.add(new Subject("ME413", "Design For Manufacture"));
	MECH41.add(new Subject("ME452", "Composite Materials"));
	MECH41.add(new Subject("CE452", "Disaster Mitigation And Management"));

	subject.put("mech41",MECH41);

	ArrayList<Subject> MECH42 = new ArrayList<Subject>();

	MECH42.add(new Subject("ME450", "Production Drawing"));
	MECH42.add(new Subject("ME461", "Production And Operations Management"));
	MECH42.add(new Subject("EC441", "Microprocessor Applications"));
	MECH42.add(new Subject("ME453", "Artificial Intelligence & Expert Systems"));
	MECH42.add(new Subject("ME454", "Machine Tool Design"));
	MECH42.add(new Subject("ME455", "Manufacturing Systems And Simulations"));
	MECH42.add(new Subject("ME456", "Mechatronics"));
	MECH42.add(new Subject("LA454", "Intellectual Property Rights"));
	MECH42.add(new Subject("ME462", "Nano Materials And Technology"));
	MECH42.add(new Subject("ME463", "Power Plant Engineering"));
	MECH42.add(new Subject("CS403", "Information Security"));
	MECH42.add(new Subject("ME457", "Robotics"));
	MECH42.add(new Subject("ME458", "Product Design And Process Planning"));
	MECH42.add(new Subject("ME459", "Modern Machining And Forming Methods"));
	MECH42.add(new Subject("ME460", "Plastics Engineering And Technology"));
	MECH42.add(new Subject("CS452", "Computer Graphics"));
	MECH42.add(new Subject("CS408", "Internet Programming"));
	MECH42.add(new Subject("ME464", "Fuels And Combustion"));
	MECH42.add(new Subject("ME465", "Rapid Prototyping Technologies"));
	MECH42.add(new Subject("ME467", "Total Quality Mangement"));

	subject.put("mech42",MECH42);

	ArrayList<Subject> IT21 = new ArrayList<Subject>();

	IT21.add(new Subject("BIT201", "Discrete Mathematics"));
	IT21.add(new Subject("BIT202", "Micro Electronics"));
	IT21.add(new Subject("BIT203", "Digital Electronics And Logic Design"));
	IT21.add(new Subject("BIT204", "Data Structures"));
	IT21.add(new Subject("EE223", "Electrical Circuits And Machines"));
	IT21.add(new Subject("CE222", "Environmental Studies"));

	subject.put("it21",IT21);

	ArrayList<Subject> IT22 = new ArrayList<Subject>();

	IT22.add(new Subject("BIT251", "Probability And Random Processes"));
	IT22.add(new Subject("BIT252", "Signals And Systems"));
	IT22.add(new Subject("BIT253", "Web Technologies"));
	IT22.add(new Subject("BIT254", "Computer Organization And Microprocessors"));
	IT22.add(new Subject("BIT255", "OPP Using JAVA"));
	IT22.add(new Subject("BIT256", "Data Communications"));

	subject.put("it22",IT21);

	ArrayList<Subject> IT31 = new ArrayList<Subject>();

	IT31.add(new Subject("CM321", "Managerial Economics And Accountancy"));
	IT31.add(new Subject("BIT302", "Software Engineering"));
	IT31.add(new Subject("BIT303", "Digital Signal Processing"));
	IT31.add(new Subject("BIT304", "Database Systems"));
	IT31.add(new Subject("BIT305", "Operating Systems"));
	IT31.add(new Subject("BIT306", "Theory Of Automata"));

	subject.put("it31",IT31);

	ArrayList<Subject> IT32 = new ArrayList<Subject>();

	IT32.add(new Subject("BIT351", "Computer Networks"));
	IT32.add(new Subject("BIT352", "Compiler Construction"));
	IT32.add(new Subject("BIT353", "Object Oriented Systems Development"));
	IT32.add(new Subject("BIT354", "Artificial Intelligence"));
	IT32.add(new Subject("BIT355", "Design & Analysis Of Algorithm"));
	IT32.add(new Subject("BIT356", "Computer Graphics"));
	IT32.add(new Subject("BIT357", "Data Warehouring And Data Mining"));
	IT32.add(new Subject("BIT358", "Software Testing"));
	IT32.add(new Subject("BIT359", "Digital Instrumentation And Control"));

	subject.put("it32",IT32);

	ArrayList<Subject> IT41 = new ArrayList<Subject>();

	IT41.add(new Subject("BIT401", "VLSI Design"));
	IT41.add(new Subject("BIT402", "Middleware Technologies"));
	IT41.add(new Subject("BIT403", "Information Security"));
	IT41.add(new Subject("BIT404", "Wireless And Mobile Communications (Elective-II)"));
	IT41.add(new Subject("BIT405", "Ad-Hoc And Sensor Networks (Elective-II)"));
	IT41.add(new Subject("BIT406", "Distributed Systems (Elective-II)"));
	IT41.add(new Subject("LA473", "Intellectual Property Rights (Elective-II)"));
	IT41.add(new Subject("IT408", "Digital Image Processing (Elective – III)"));
	IT41.add(new Subject("IT409", "Grid Computing (Elective-III)"));
	IT41.add(new Subject("IT410", "CPLD And FPGA Architectures (Elective – III)"));
	IT41.add(new Subject("IT411", "Software Reuse Techniques (Elective – III)"));
	IT41.add(new Subject("IT412", "Semantic WEeb (ELECTIVE –III)"));

	subject.put("it41",IT41);

	ArrayList<Subject> IT42 = new ArrayList<Subject>();

	IT42.add(new Subject("BIT451", "Embedded Systems"));
	IT42.add(new Subject("BIT452", "Information Retrieval Systems"));
	IT42.add(new Subject("BIT453", "Information Storage And Management"));
	IT42.add(new Subject("BIT454", "Simulation And Modeling"));
	IT42.add(new Subject("BIT455", "Advanced Computer Architecture"));
	IT42.add(new Subject("BIT456", "Natural Language Processing"));
	IT42.add(new Subject("BIT457", "Soft Computing"));
	IT42.add(new Subject("BIT458", "Human Computer Interaction"));
	IT42.add(new Subject("BIT459", "Software Project Management"));
	IT42.add(new Subject("BIT460", "Cloud Computing"));
	IT42.add(new Subject("ME411", "Entrepreneurship"));
	IT42.add(new Subject("BIT461", "Disaster Management"));

	subject.put("it42",IT42);

	ArrayList<Subject> PROD21 = new ArrayList<Subject>();

	PROD21.add(new Subject("MT201", "Mathematics-III"));
	PROD21.add(new Subject("ME201", "Metallurgy And Material Science"));
	PROD21.add(new Subject("ME202", "Machine Drawing"));
	PROD21.add(new Subject("CE221", "Mechanics Of Materials"));
	PROD21.add(new Subject("CE222", "Environmental Studies"));
	PROD21.add(new Subject("CM221", "Managerial Economics And Accountancy"));

	subject.put("prod21",PROD21);

	ArrayList<Subject> PROD22 = new ArrayList<Subject>();

	PROD22.add(new Subject("MT251", "Mathematics-IV"));
	PROD22.add(new Subject("ME251", "Kinematics Of Machines"));
	PROD22.add(new Subject("EE221", "Electrical Circuits And Machines"));
	PROD22.add(new Subject("ME253", "Thermo Dynamics"));
	PROD22.add(new Subject("EC222", "Basic Electronics"));
	PROD22.add(new Subject("CE271", "Fluid Dynamics"));

	subject.put("prod22",PROD22);

	ArrayList<Subject> PROD31 = new ArrayList<Subject>();

	PROD31.add(new Subject("MP301", "Applied Thermodynamics And Heat Transfer"));
	PROD31.add(new Subject("MP303", "Machine Tool Engineering"));
	PROD31.add(new Subject("MP304", "Metal Forming Technology"));
	PROD31.add(new Subject("ME302", "Dynamics Of Machines"));
	PROD31.add(new Subject("ME303", "Design Of Machine Elements"));

	subject.put("prod31",PROD31);

	ArrayList<Subject> PROD32 = new ArrayList<Subject>();

	PROD32.add(new Subject("MP351", "Turbo Machinery"));
	PROD32.add(new Subject("MP352", "Metal Casting And Welding"));
	PROD32.add(new Subject("MP353", "CAD/FEM"));
	PROD32.add(new Subject("ME351", "Machine Design"));
	PROD32.add(new Subject("ME356", "Refrigeration And Air Conditioning"));

	subject.put("prod32",PROD32);

	ArrayList<Subject> PROD41 = new ArrayList<Subject>();

	PROD41.add(new Subject("MP401", "Production Drawing Practice"));
	PROD41.add(new Subject("ME402", "Metrology And Instrumentation"));
	PROD41.add(new Subject("ME404", "Operations Research"));
	PROD41.add(new Subject("ME355", "Control System Theory"));
	PROD41.add(new Subject("ME403", "Finite Element Analysis"));
	PROD41.add(new Subject("ME406", "Neural Networks"));
	PROD41.add(new Subject("ME407", "Automobile Engineering"));
	PROD41.add(new Subject("ME411", "Entrepreneurship"));
	PROD41.add(new Subject("ME412", "Computational Fluid Flows"));
	PROD41.add(new Subject("ME413", "Design For Manufacture"));
	PROD41.add(new Subject("ME452", "Composite Materials"));
	PROD41.add(new Subject("ME467", "Total Quality Management"));
	PROD41.add(new Subject("CE452", "Disaster Mitigation And Management"));

	subject.put("prod41",PROD41);

	ArrayList<Subject> PROD42 = new ArrayList<Subject>();

	PROD42.add(new Subject("ME409", "Tool Design"));
	PROD42.add(new Subject("ME461", "Production And Operations Management"));
	PROD42.add(new Subject("EC441", "Microprocessor Applications"));
	PROD42.add(new Subject("ME453", "Artificial Intelligence & Expert Systems"));
	PROD42.add(new Subject("ME454", "Machine Tool Design"));
	PROD42.add(new Subject("ME455", "Manufacturing Systems And Simulations"));
	PROD42.add(new Subject("ME456", "Mechatronics"));
	PROD42.add(new Subject("LA454", "Intellectual Property Rights"));
	PROD42.add(new Subject("ME462", "Nano Materials And Technology"));
	PROD42.add(new Subject("ME463", "Power Plant Engineering"));
	PROD42.add(new Subject("CS403", "Information Security"));
	PROD42.add(new Subject("ME457", "Robotics"));
	PROD42.add(new Subject("ME458", "Product Design And Process Planning"));
	PROD42.add(new Subject("ME459", "Modern Machining And Forming Methods"));
	PROD42.add(new Subject("ME460", "Plastics Engineering And Technology"));
	PROD42.add(new Subject("CS452", "Computer Graphics"));
	PROD42.add(new Subject("CS408", "Internet Programming"));
	PROD42.add(new Subject("ME465", "Rapid Prototyping Technologies"));
	PROD42.add(new Subject("ME466", "Material Handling"));
	PROD42.add(new Subject("ME468", "Non-Destructive Testing"));

	subject.put("prod42",PROD42);

	ArrayList<Subject> EIE21 = new ArrayList<Subject>();

	EIE21.add(new Subject("MT201", "Mathematics-III"));
	EIE21.add(new Subject("CE222", "Environmental Studies"));
	EIE21.add(new Subject("EE203", "Network Theory"));
	EIE21.add(new Subject("EE204", "Electrical Measurements And Instruments"));
	EIE21.add(new Subject("EC221", "Electronic Enginnering-I"));
	EIE21.add(new Subject("ME222", "Elements Of Production Techniques"));

	subject.put("eie21",EIE21);

	ArrayList<Subject> EIE22 = new ArrayList<Subject>();

	EIE22.add(new Subject("CE223", "Solid Mechanics"));
	EIE22.add(new Subject("EE252", "Electromagnetic Fields"));
	EIE22.add(new Subject("EE256", "Electrical Machines"));
	EIE22.add(new Subject("EE257", "Transducer Engineering"));
	EIE22.add(new Subject("ME272", "Thermodynamics And Fluid Mechanics"));
	EIE22.add(new Subject("EC271", "Electronic Engineering-II"));

	subject.put("eie22",EIE22);

	ArrayList<Subject> EIE31 = new ArrayList<Subject>();

	EIE31.add(new Subject("EE303", "Power Electronics"));
	EIE31.add(new Subject("EE304", "Digital Electronics And Logic Design"));
	EIE31.add(new Subject("EE305", "Linear Integrated Circuits"));
	EIE31.add(new Subject("EE306", "Linear Control Systems"));
	EIE31.add(new Subject("EE311", "Instrumentation Systems"));
	EIE31.add(new Subject("EE312", "Signal And Systems"));

	subject.put("eie31",EIE31);

	ArrayList<Subject> EIE32 = new ArrayList<Subject>();

	EIE32.add(new Subject("EE350", "Digital Signal Processing And Applications"));
	EIE32.add(new Subject("EE354", "Microprocessor And Microcontrollers"));
	EIE32.add(new Subject("EE356", "Power Plant Instrumentation"));
	EIE32.add(new Subject("EE357", "Process Control"));
	EIE32.add(new Subject("EE358", "Biomedical Instrumentation"));
	EIE32.add(new Subject("CM371", "Managerial Economics And Accountancy"));

	subject.put("eie32",EIE32);

	ArrayList<Subject> EIE41 = new ArrayList<Subject>();

	EIE41.add(new Subject("EE404", "Opto-Electronics Instrumentation"));
	EIE41.add(new Subject("EE405", "Virtual Instrumentation"));
	EIE41.add(new Subject("EE406", "Analytical Instrumentation"));
	EIE41.add(new Subject("EE415", "Automation In Process Control"));
	EIE41.add(new Subject("EE416", "Digital Control System"));
	EIE41.add(new Subject("CS421", "Operating System Concepts"));
	EIE41.add(new Subject("CS467", "Embedded Systems"));
	EIE41.add(new Subject("ME411", "Entrepreneurship"));
	EIE41.add(new Subject("CS403", "Information Security"));

	subject.put("eie41",EIE41);

	ArrayList<Subject> EIE42 = new ArrayList<Subject>();

	EIE42.add(new Subject("EE452", "Electronic Instrumentation Systems"));
	EIE42.add(new Subject("EE464", "Advanced PLC Programming"));
	EIE42.add(new Subject("EE462", "Advanced Control Systems"));
	EIE42.add(new Subject("EE463", "Optimization Methods"));
	EIE42.add(new Subject("EC402", "VLSI Design"));
	EIE42.add(new Subject("LA454", "Intellectual Property Rights"));
	EIE42.add(new Subject("CE452", "Disaster Mitigation And Management"));
	EIE42.add(new Subject("EE471", "Renewable Energy Sources"));
	EIE42.add(new Subject("EE474", "Advanced Digital Signal Processing"));
	EIE42.add(new Subject("EE475", "Process Plant Design And Safety Management"));
	EIE42.add(new Subject("ME457", "Robotics"));
	EIE42.add(new Subject("CS413", "Image Processing"));
	EIE42.add(new Subject("CS415", "Soft Computing"));

	subject.put("eie42",EIE42);
		subjectHashMap = subject;
		return  subjectHashMap;
}
}
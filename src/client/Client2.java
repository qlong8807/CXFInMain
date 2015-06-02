package client;

import java.io.IOException;

public class Client2 {
	public static void main(String[] args) throws IOException {

		/*HandleServiceTest factory = new HandleServiceTest();
		HandleService handleService = factory.getHandleServiceImplPort();

		Client client = ClientProxy.getClient(handleService);
		client.getOutInterceptors().add(
				new AddHeaderInterceptor("lzw", "123456"));
		client.getOutInterceptors().add(
				new LoggingOutInterceptor(new PrintWriter(new FileWriter(
						"in.txt"))));
		client.getInInterceptors().add(
				new LoggingInInterceptor(new PrintWriter(new FileWriter(
						"out.txt"))));
		System.out.println(handleService.sayName("内马尔"));
		ClubModel clubModel = new ClubModel();
		clubModel.setClubId(1111);
		clubModel.setClubName("巴塞罗那");
		clubModel.setCountry("西班牙");
		System.out.println("============================");
		List<PlayerModel> players = handleService.getPlayerByClub(clubModel);
		for (PlayerModel play : players) {
			System.out.println(play.getPlayerName());
		}
		System.out.println("============================");
		StringPlayer allPlayer = handleService.getAllPlayers();
		for (Entry entry : allPlayer.getEntries()) {
			System.out.println(entry.getKey()
					+ entry.getValue().getPlayerName());
		}*/
	}
}

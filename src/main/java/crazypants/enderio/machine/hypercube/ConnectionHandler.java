package crazypants.enderio.machine.hypercube;

import net.minecraft.entity.player.EntityPlayerMP;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent.ClientDisconnectionFromServerEvent;
import crazypants.enderio.EnderIO;

public class ConnectionHandler {

  //to lazy to create a new class
  @SubscribeEvent
  public void onPlayerLoggon(PlayerLoggedInEvent evt) {
    EnderIO.packetPipeline.sendTo(new PacketChannelList(evt.player, true), (EntityPlayerMP) evt.player);
    EnderIO.packetPipeline.sendTo(new PacketChannelList(evt.player, false), (EntityPlayerMP) evt.player);
  }

  @SubscribeEvent
  public void onDisconnectedFromServer(ClientDisconnectionFromServerEvent evt) {
    //TODO:1.7 this is never called
    System.out.println("################################################################### BlockHyperCube.onDisconnectedFromServer: ");
    ClientChannelRegister.instance.reset();
  }

}

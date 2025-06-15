@Allcampaigns
Feature: Verify LMX Negotiation Expiry Date Feature.

  Scenario Outline: Generate a proposal
  Given Click deals and select plan a campaign and generate the proposal
  
   Scenario Outline: All campaigns
  Given User check the Created propsal is listed in Generated state in All campaigns Page.
  
  Scenario Outline: Negotiation
  When Click Negotiation button in proposal page
  
  Scenario Outline: Countour prices
  When User provide counter prices for the inventories
  
  Scenario Outline: Campaign status
  When User check the status of the campaign after providing counter prices and save the proposal
  
  Scenario Outline: Billboard list
  When User check the negotiated campaign is not listed in Generated list.
  
  Scenario Outline: Billboard list
  When User check the negotiated campaign is listed in under negotiation tab in Negotiotion Stage.
  
  Scenario Outline: Archeived stage
  When User check the under negotiation is campaign moved to archeived stage after reaching expiry date
  
  Scenario Outline: Approve Negotiation
  When User should generate proposal and approve negotiation 
  
  Scenario Outline: Approve Negotiation status
  When User check whether negotiation approved proposal moved to archeived stage.
  
  Scenario Outline: Reserve Proposal
  When User should generate proposal and reserve the proposal
  
  Scenario Outline: Reserved proposal status
  When User check whether reserved proposal moved to archeived stage.
  
   Scenario Outline: Book Proposal
  When User should generate proposal and Book the proposal
  
  Scenario Outline: Booked proposal status
  When User check whether Booked proposal moved to archeived stage.
   
  Scenario Outline: Reopen Reserve Proposal
  When User should reopen reserved proposal and make negotiation
  
  Scenario Outline: Reopen Reserved proposal status
  When User checks the reopened reserved proposal has moved to the archived stage after negotiation after reaching its expiry validity
  
  Scenario Outline: Reopen Booked Proposal
  When User should reopen Booked proposal and make negotiation
  
  Scenario Outline: Reopen Booked proposal status
  When User checks the reopened booked proposal has moved to the archived stage after negotiation after reaching its expiry validity
  
  
  
   
  